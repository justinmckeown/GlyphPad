/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import glyphpad.utilities.unicodeTranslatorUtility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Dictionary;
import java.util.HashMap;
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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.StringConverter;
import javax.xml.bind.ParseConversionEvent;
import oracle.jrockit.jfr.events.ContentTypeImpl;

/**
 * FXML Controller class
 *
 * @author Justin McKeown
 */
public class PredicateLogicPadController implements Initializable {
    @FXML MenuBar menuBar; 
    @FXML Menu fileMenu, editMenu, mathsEngines, accessibilityMenu, helpMenu;
    @FXML MenuItem open, close, save, saveAs, selectAll, copy, paste, delete, about; 
    @FXML CheckMenuItem dyslexicMode;
    @FXML TextArea textPad;
    @FXML TextArea feedbackText;
    GlyphStore glyphs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //HIDE THEE STUFF i'M DEVELOPING
        mathsEngines.setVisible(false);
        feedbackText.setVisible(false);
        
        //glyphs = new GlyphStore();
        Map<String, String> hm;
        glyphs = new GlyphStore();
        hm = glyphs.getPredicateLogic();
        
        hm.putAll((Map<? extends String, ? extends String>) glyphs.getSetTheory());
        
        textPad.textProperty().addListener(new ChangeListener<String>(){
            
            Pattern pattern = Pattern.compile("(?s)\\\\\\w{3,5}", Pattern.CASE_INSENSITIVE);    
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue){
                //System.out.println("OLD VALUE: "+ oldValue + "\nNEW VALUE: "+newValue);
                //System.out.println("OBSERVABLE VALUE: "+ observable);
                int cp = textPad.caretPositionProperty().get();
                Matcher matcher = pattern.matcher(newValue);
                String replacement = null;
                while(matcher.find()){
                    replacement = matcher.group();
                }
                
                for(Map.Entry<String, String> entry : hm.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(replacement)){
                        replaceSymbol(entry.getKey(), entry.getValue(), cp);
                    }else if(replacement != null){
                        System.out.println("NO MATCH FOR: "+replacement);
                    }
                }
            }
        });
                
    }
    
    private void replaceSymbol(String replacementCode, String uc, int crt){
        int cp = (crt -(replacementCode.length()-2));
        Platform.runLater(()->{
                        String txt = textPad.getText();
                        textPad.setText(txt.replace(replacementCode, uc));
                        textPad.positionCaret(cp);
                    });          
        }
 
    @FXML
    private void openSelected(ActionEvent ev) {
        //System.out.println("open button pressed");
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File("Documents"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
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
                pc.setTextPadOnLoad(finalText.toString());
                Parent p = loader.getRoot();
                p.getStylesheets().add("mathpad.styles/mathpad.css");
                Stage stage = new Stage();
                stage.setTitle(selectedFile.getName());
                stage.setScene(new Scene(p));
                stage.showAndWait();
            }
        }
    }
    
    @FXML
    private void closeSelected(ActionEvent ev){
        System.out.println("close button pressed");
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        
        //do a check to see if the file has changed since last save...
        
        //if it has not been saved then ask the user if they want to save before closing...
        
        //then close the file
        theStage.close();
    }
    
    @FXML
    private void saveSelected(ActionEvent ev){
        System.out.println("save button pressed");
  
        String fileToSave = textPad.getText();
        
        Stage theStage = (Stage) menuBar.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("save File in .txt format");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", ".txt");
        fileChooser.getExtensionFilters().add(filter);
        Window stage = null;
        File file = fileChooser.showSaveDialog(stage);
        
        try{
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(fileToSave);
            writer.close();
        }catch(Exception e){
            System.err.println("PredicateLogicPadController().saveSelected(): ERROR saving file: "+e);
        }
    }
    
    @FXML
    private void saveAsSelected(ActionEvent ev){
        System.out.println("saveAs button pressed");
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
            region.setBackground(new Background(new BackgroundFill(Paint.valueOf("#B5B2BB"), CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            region.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    
    @FXML
    private void aboutSelected(ActionEvent ev){
        System.out.println("dyslexicMode button pressed");
    }
    
    
    public void setTextPadOnLoad(String s){
        textPad.setText(s);
    }
}