/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import glyphpad.utilities.FileUtility;
import glyphpad.utilities.InputTests;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Justin McKeown
 */
public class PredicateLogicPadController implements Initializable {
    @FXML MenuBar menuBar; 
    @FXML Menu fileMenu, editMenu, mathsEngines, accessibilityMenu, helpMenu;
    @FXML MenuItem newPad, open, close, save, saveAs, selectAll, copy, paste, delete, about, userGuide; 
    @FXML CheckMenuItem dyslexicMode;
    @FXML TextArea textPad;
    @FXML TextArea feedbackText;
    GlyphStore glyphs;

    private static int fileHash; 
    private static String fileName;
    private static String filePath;
    private static String lastDirectory;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //HIDE THEE STUFF I'M CURRENTLY DEVELOPING...
        mathsEngines.setVisible(false);
        feedbackText.setVisible(false);
        
        //Get the file hash of the initial file when its opened. This will be used to check for change sin the state of the file prior to it neing closed. 
        fileHash = textPad.getText().hashCode();
        fileName = null;
        filePath = null;
        lastDirectory = null;
        
        //glyphs = new GlyphStore();
        Map<String, String> hm;
        glyphs = new GlyphStore();
        hm = glyphs.getPredicateLogic();
        hm.putAll((Map<? extends String, ? extends String>) glyphs.getSetTheory());
        
        Map<String, String> coreMath;
        coreMath = glyphs.getCoreMaths();
        hm.putAll(coreMath);
        
        Map<String, String> otherChars; 
        otherChars = glyphs.getOtherChars();
        hm.putAll(otherChars);
        
        //Subscripts collections...
        Map<String, String> subscriptMaps;
        subscriptMaps = glyphs.getSubscripts();
        
        //Superscripts collections...
        Map<String, String> superscriptMaps;
        superscriptMaps = glyphs.getSuperscripts();
        
        textPad.textProperty().addListener(new ChangeListener<String>() {
            
            
            Pattern pattern = Pattern.compile("(?s)\\\\[[^_]&&a-zA-Z]{3,5}", Pattern.CASE_INSENSITIVE); //TODO: should this be case sensitive?    
            Pattern subcase = Pattern.compile("(?s)\\\\_[a-zA-Z0-9\\+\\-\\=\\(\\)]{0,}_", Pattern.CASE_INSENSITIVE); //TODO: should this be case sensitive?
            Pattern supercase = Pattern.compile("(?s)\\\\\\^[a-zA-Z0-9\\+\\-\\=\\(\\)]{0,}\\^", Pattern.CASE_INSENSITIVE); //TODO: should this be case sensitive?    
            
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue){
                System.out.println("OLD VALUE: "+ oldValue);
                System.out.println("NEW VALUE: "+ newValue);
                System.out.println("TEXT PAD CONTENT: "+textPad.getAccessibleText());
                
                int cp = textPad.caretPositionProperty().get();
                String replacement = null;
                
                //find a glyph (set theory or propositional logic)
                Matcher matcher = pattern.matcher(newValue);
                while(matcher.find()){
                    //System.out.println("Searching for glyph match ");
                    replacement = matcher.group();
                }
                
                //find a subscript
                Matcher matchSubrscript = subcase.matcher(newValue);
                while(matchSubrscript.find()){
                    //System.out.println("Searching for Subscript match");
                    replacement = matchSubrscript.group();
                }
                
                 //find a subscript
                Matcher matchSuperscript = supercase.matcher(newValue);
                while(matchSuperscript.find()){
                    //System.out.println("Searching for Superscript match");
                    replacement = matchSuperscript.group();
                }
                
                System.out.println("caretPosition: "+ cp);
                if(replacement != null){
                    replacement = replacement.trim();
                    
                    //If its a glyph...
                    if(replacement.matches(pattern.pattern())){
                        for(Map.Entry<String, String> entry : hm.entrySet()) {
                            if(entry.getKey().equalsIgnoreCase(replacement)){
                                replaceSymbol(entry.getKey(), entry.getValue(), cp);
                                replacement = null;
                            }
                        }
                    }
                    //If its a subscript...
                    else if(replacement.matches(subcase.pattern())){
                        String cleanedString = cleanString(replacement, "_");
                        if(InputTests.subscriptText(cleanedString)){
                            replaceSymbol(replacement, replacementString(cleanedString, subscriptMaps), cp);
                            replacement = null;
                        }else {
                            newAlert("Subscripts can only contain the following values: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, +, -, =, (, ), a, e, g, h, k, l, m, n, o, p, s, t, x. Please review your input and try again");
                        }
                    }
                    //if its a superscript...
                    else if(replacement.matches(supercase.pattern())){
                        //System.out.println("Match for superscript input found");
                        String cleanedString = cleanString(replacement, "\\^");
                        if(InputTests.superscriptText(cleanedString)){
                            replaceSymbol(replacement, replacementString(cleanedString, superscriptMaps), cp);
                            replacement = null;
                        }else{
                            newAlert("Superscripts can only contain the following values: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, +, -, =, (, ), n. Please review your input and try again");
                        }
                    }
                    else{
                        replacement = null;
                    }
                }
            }
        });         
    }
    
    private void replaceSymbol(String userInputShortCode, String unicodeGlyph, int crt){
        Platform.runLater(()->{
            int caretPosition;
            if(userInputShortCode.startsWith("\\_") || userInputShortCode.startsWith("\\^")){
                caretPosition = crt-2;
            }else {
                caretPosition = (crt -(userInputShortCode.length()-2));
            }
                        String txt = textPad.getText();
                        textPad.setText(txt.replace(userInputShortCode, unicodeGlyph));
                        textPad.positionCaret(caretPosition);
                    });          
        }
    
    private String cleanString (String s, String framingChars){
        String str = s.replaceAll(framingChars, "");
        String cleanedString = str.replace("\\", "");
        return cleanedString;
    }
    
    private String replacementString(String cleanedString, Map<String, String> map) {
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < cleanedString.length(); i++) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (cleanedString.charAt(i) == entry.getKey().charAt(0)) {
                    str.append(entry.getValue());
                }
            }
        }
        return str.toString();
    }
    
    private void newAlert(String message){
       Alert a = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
       a.showAndWait();
    }
    
    //********************************************* SECTION: MENU BUTTON FUNCTIONALITY *****************************************************
    
    @FXML
    private void newGlyphPad(ActionEvent ev){
        //System.out.println("New Button pressed");
        loadNewView("PredicateLogicPad.fxml", "GlyphPad");
    }
 
    @FXML
    private void openSelected(ActionEvent ev) {
        //System.out.println("open button pressed");
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        
        if(lastDirectory != null){
            System.out.println("FILE PATH"+getFilePath());
            fileChooser.setInitialDirectory(new File(getLastDirectory()));
        }
        File selectedFile = fileChooser.showOpenDialog(theStage);

        if (selectedFile == null) {
            System.out.println("PredicateLogicPadController.opeSelected(): File opening interrupted so value is NULL");
        } else {
            //Check we can read the file
            if (!selectedFile.canRead()) {
                Alert a;
                a = new Alert(Alert.AlertType.ERROR, "This file format cannot be opened with this application", ButtonType.OK);
                a.showAndWait();
            } else {
                
                StringBuffer finalText = new StringBuffer("");
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        finalText.append(line).append(System.getProperty("line.separator"));
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //load the text into a new window....    
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("PredicateLogicPad.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {

                }
                PredicateLogicPadController pc = loader.getController();
                try {
                    pc.setTextPadOnLoad(finalText.toString(), selectedFile.getCanonicalPath()); //add in the file path and file name
                    System.out.println("Canonical Path: "+selectedFile.getCanonicalPath());
                } catch (IOException ex) {
                    Logger.getLogger(PredicateLogicPadController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parent p = loader.getRoot();
                p.getStylesheets().add("glyphpad/styles/glyphpad.css");
                Stage stage = new Stage();
                stage.setTitle(selectedFile.getName());
                stage.setScene(new Scene(p));
                stage.showAndWait();
            }
        }
    }
    
    @FXML
    private void closeSelected(ActionEvent ev){
        //System.out.println("close button pressed");
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        
        //DEBUG: do a check to see if the file has changed since last save...
        //System.out.println("SavedHash: "+getFileHash());
        //System.out.println("CurrentHash: "+ textPad.getText().hashCode());
        
        if(getFileHash()==textPad.getText().hashCode()){
            System.out.println("Saving is fine");
            theStage.close();
        }else{
            System.out.println("Saving is not fine");
            Alert a = new Alert(Alert.AlertType.WARNING, "The file has changed since your last Save. Are you sure you want to close without Saving?", ButtonType.OK, ButtonType.CANCEL);
            a.showAndWait();
            
            //if user selected ok close the stage. 
            if (a.getResult() == ButtonType.OK){
                theStage.close();
            }
        }
    }
    
    @FXML
    private void saveSelected(ActionEvent ev){
        System.out.println("save button pressed");
        
        if(fileName == null){
            //save the file with a dialog box
            boolean filesaved = saveAs();
        }else {
            //just save the file to the save filepath. 
            File file = new File(getFilePath());
            boolean saveSuccessful = false;
        try{
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(textPad.getText());
            writer.close();
            saveSuccessful = true;
            setFileHash(textPad.getText().hashCode());
        }catch(Exception e){
            System.err.println("PredicateLogicPadController().saveSelected(): ERROR saving file: "+e);
        }
        }
    }
    
    @FXML
    private void saveAsSelected(ActionEvent ev){
        //System.out.println("saveAs button pressed");
        boolean saved = saveAs();
    }
    
    private boolean saveAs(){
        
        String fileToSave = textPad.getText();
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("save File in .txt format");
        
        FileChooser.ExtensionFilter text = new FileChooser.ExtensionFilter("TXT files", "*.txt");
        FileChooser.ExtensionFilter everything = new FileChooser.ExtensionFilter("All files", "*.*");
        fileChooser.getExtensionFilters().addAll(text, everything);
        
        if(lastDirectory != null){
            //TODO: For some reason saying if 'not null' was thorwing an error. Figure out why
            fileChooser.setInitialDirectory(new File(getLastDirectory()));
        }
        
        Window stage = null;
        File file = fileChooser.showSaveDialog(stage);
        boolean saveSuccessful = false;
        try{
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(fileToSave);
            writer.close();
            saveSuccessful = true;
        }catch(Exception e){
            System.err.println("PredicateLogicPadController().saveSelected(): ERROR saving file: "+e);
        }
        if(saveSuccessful){
            theStage.setTitle(file.getName());
            setFileName(file.getName());
            setFilePath(file.getAbsolutePath());
            System.out.println("glyphpad.PredicateLogicPadController.saveTheFile() The cannonical file path: "+ getFilePath());
        }
        setFileHash(textPad.getText().hashCode());
        setLastDirectory(FileUtility.getDirectoryFromPath(getFilePath()));
        return saveSuccessful;
    }
    
    
    @FXML
    private void selectAll(ActionEvent ev){
        textPad.selectAll();
    }
    
    @FXML
    private void copySelected(ActionEvent ev){
        System.out.println("copy button pressed");
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(textPad.getSelectedText());
        clipboard.setContent(content);
    }
    
    
    @FXML
    private void pasteFromClipboard(ActionEvent ev) {
        System.out.println("paste button pressed");
        
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (clipboard.hasString()) {
            textPad.replaceSelection(clipboard.getString());
        }

    }
    
    
    @FXML
    private void deleteSelected(ActionEvent ev){
        System.out.println("deleteSelected button pressed");
        textPad.deleteText(textPad.getSelection());
    }
    
    
    @FXML
    private void predicateLogicEngineSelected(ActionEvent ev){
        System.out.println("predicateLogicEngineSelected button pressed");
        
    }

    @FXML
    private void SetTheoryEngineSelected(ActionEvent ev){
        System.out.println("SetTheoryEngineSelected button pressed");
        
    }
    
    @FXML
    private void dyslexicModeSelected(ActionEvent ev) {
        System.out.println("dyslexicMode button pressed");
        Region region = (Region) textPad.lookup(".content");
        if (dyslexicMode.isSelected()) {
            region.setBackground(new Background(new BackgroundFill(Paint.valueOf("#f6f5f1"), CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            region.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    
    @FXML
    private void aboutSelected(ActionEvent ev) {
        loadNewView("About.fxml", "About GlyphPad Beta");
    }
    
    @FXML
    private void userGuideSelected(ActionEvent ev) {
        loadNewView("HelpView.fxml", "GlyphPad Help");
    }
    
    
    private void loadNewView(String fxml, String title){
        
         try {
         ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println("url is " + url.getFile());
        }  
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            root.getStylesheets().add("glyphpad/styles/glyphpad.css");
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            //stage.getIcons().add(new Image(this.getClass().getResourceAsStream("glyphpad/icons/Logo400.png")));
            stage.getIcons().add(new Image(("glyphpad/icons/Logo400.png")));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicateLogicPadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
    
    public void setTextPadOnLoad(String s, String path){
        textPad.setText(s);
        setFileName(s);
        setFilePath(path);
        setLastDirectory(FileUtility.getDirectoryFromPath(path));
        setFileHash(textPad.getText().hashCode());
        //REPORT:
        System.out.println("FILE NAME: "+ getFileName());
        System.out.println("PATH: "+ getFilePath());
        System.out.println("DIRECTORY: "+ getLastDirectory());
        System.out.println("HASH: "+ getFileHash());
    }

 

       //*************************************************************** GETTERS AND SETTERS **********************************************************************
    public static int getFileHash() {
        return fileHash;
    }

    public static void setFileHash(int fileHash) {
        PredicateLogicPadController.fileHash = fileHash;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        PredicateLogicPadController.fileName = fileName;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        PredicateLogicPadController.filePath = filePath;
    }

    public static String getLastDirectory() {
        return lastDirectory;
    }

    public static void setLastDirectory(String lastDirectory) {
        PredicateLogicPadController.lastDirectory = lastDirectory;
    }
    
    
}