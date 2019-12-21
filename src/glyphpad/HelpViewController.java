/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import glyphpad.utilities.TextFormatUtility;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Justin McKeown
 */
public class HelpViewController implements Initializable {

    @FXML TextFlow textFlow;
    @FXML Text textTitle;
    @FXML ScrollPane scrollPane;
    @FXML TreeView<String> helpMenu;
    
    
    HelpTextStore helpTextStore;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        textFlow.setMaxWidth(800);

        LinkedHashMap<String, String> propositionalLogicText;
        LinkedHashMap<String, String> setTheoryText;
        LinkedHashMap<String, String> otherSymbolsText;

        helpTextStore = new HelpTextStore();
        propositionalLogicText = helpTextStore.getHelpText();
        setTheoryText = helpTextStore.getSetTheoryTextHelp();
        otherSymbolsText = helpTextStore.getOtherCharsTextHelp();
        
        
        formatText(propositionalLogicText, setTheoryText, otherSymbolsText);
        
        double edgeBuffer = 20;
        scrollPane.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow.setMaxWidth((newValue.doubleValue()-edgeBuffer));
            }
            
        });
        
        //Set up help menu
        TreeItem<String> root, overview, glyphList, pLogicList, sTList, zList, propositionalLogic, setTheory;
        
        root = new TreeItem<>();
        root.setExpanded(true);
        
        
        //Overview branch
        overview = newBranch("Overview", root);
        newBranch("Introduction", overview);
        newBranch("glyphCode Rules", overview);
        glyphList = newBranch("glyphCode Lists", overview);
        pLogicList = newBranch("Propositional Logic", glyphList);
        sTList = newBranch("Set Theory", glyphList);
        zList = newBranch("Other glyphCodes", glyphList);
        
        
        newBranch("quick start tutorial", overview);
        
        propositionalLogic = newBranch("Propositional Logic", root);
        newBranch("Negation", propositionalLogic);
        newBranch("Conjunction", propositionalLogic);
        newBranch("Disjunction", propositionalLogic);
        newBranch("Implication", propositionalLogic);
        newBranch("Logical Equivalence", propositionalLogic);
        
        setTheory = newBranch("Set Theory", root);
        newBranch("Set Membership", setTheory);
        newBranch("Subsets", setTheory);
        newBranch("Proper Subsets", setTheory);
        newBranch("Supersets", setTheory);
        newBranch("Supersets", setTheory);
        newBranch("Proper Supersets", setTheory);
        newBranch("Negated relations", setTheory);
        newBranch("Set Union", setTheory);
        newBranch("Set Intersection", setTheory);
        newBranch("Set Difference", setTheory);
        newBranch("Set Equality", setTheory);
        newBranch("Set Equality", setTheory);
        newBranch("Cardinality", setTheory);
        newBranch("Power Sets", setTheory);
        newBranch("Set Compliment", setTheory);
        newBranch("Cartesian Products", setTheory);
        
        
        //add the branches to the tree by setting the root
        helpMenu.setRoot(root);
        helpMenu.setShowRoot(false);
        
    }    
    
    private void formatText(LinkedHashMap<String, String> propositionalLogic, LinkedHashMap<String, String> setTheory, LinkedHashMap<String, String> otherChars)  {
        
        //INTRO
        textFlow.getChildren().add(TextFormatUtility.headerText("Introduction"));
        textFlow.getChildren().add(TextFormatUtility.bodyText("GlyphPad is designed to make writing propositional logic and basic set theory formulas much easier. "
                + "It achieves this thorugh the use of inutivitive 'glyphCodes'. these are 3 - 5 character sequences prefixed with a backslash.\n"));
        
        //GLYPHCODES:
        textFlow.getChildren().add(TextFormatUtility.headerText("GlyphCode Rules"));
        textFlow.getChildren().add(TextFormatUtility.bodyText("GlyphCodes are designed on a set of intuitive rules:\n\n"
                + "1. A glyphCode is comrpised of the first 3 -5 letters of a symbols name prefixed with a backslash. "
                + "For exmaple, the glyphCode for the negation symbol is '\\neg'. If the user types this then the shortcode will be transformed into the negation symbol '¬'\n\n"
                + "2. The negation of a glyphCode is created by prefixing the symbols regular glyphCode with an 'n'. "
                + "for example, the glyphCode for 'Element of' is '\\ele'. The glyphCode for its negation, 'not an element of', is '\\nele'\n\n"
                + "3. A subscript character is created by following the backslash character with an underscorce, followed by the characters you wish to represent in subscript "
                + "followed by a closing using underscore. For example, the numbers 123 can be rendered in subscript by entering '\\_123_'.\n\n"
                + "4. A superscript character is created by following the backslash character with the ^ symbol, followed by the characters you wish to represent in superscript "
                + "followed by a closing ^. For example, the numbers 123 can be rendered in superscript by entering '\\^123^.'\n\n"
                + "The full list of glphyCodes currently utilised in GlyphPad are given below along with their shortcodes. It is advised you take a moment to read these.\n"));
        
        
        textFlow.getChildren().add(TextFormatUtility.headerText("GlyphCode Lists"));
        
        textFlow.getChildren().add(TextFormatUtility.headerText("Propositional Logic:"));
        for (Map.Entry<String, String> entry : propositionalLogic.entrySet()) {
            textFlow.getChildren().add(TextFormatUtility.bodyText(entry.getKey()));
        }
        
        textFlow.getChildren().add(TextFormatUtility.headerText("Set Theory:"));
        for (Map.Entry<String, String> entry : setTheory.entrySet()) {
            textFlow.getChildren().add(TextFormatUtility.bodyText(entry.getKey()));
        }
        
        textFlow.getChildren().add(TextFormatUtility.headerText("Other Mathematical Symbols:"));
        for (Map.Entry<String, String> entry : otherChars.entrySet()) {
            textFlow.getChildren().add(TextFormatUtility.bodyText(entry.getKey()));
        }
        
        /*
        
        for (Map.Entry<String, String> entry : propositionalLogic.entrySet()) {
            Text title = new Text(entry.getKey() + "\n");
            title.setFont(Font.font("Calibri", FontWeight.BOLD, 26));

            Text blurb = new Text(entry.getValue() + "\n\n");
            blurb.setFont(Font.font("Calibri", FontWeight.MEDIUM, 24));
            textFlow.getChildren().addAll(title, blurb);
        }
        
        Text setHeading = new Text("2. Set Theory: Short codes and Laws:\n\n");
        setHeading.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        textFlow.getChildren().add(setHeading);
        
        for(Map.Entry<String, String> entry : setTheory.entrySet()) {
            Text title = new Text(entry.getKey() + "\n");
            title.setFont(Font.font("Calibri", FontWeight.BOLD, 26));

            Text blurb = new Text(entry.getValue() + "\n\n");
            blurb.setFont(Font.font("Calibri", FontWeight.MEDIUM, 24));
            textFlow.getChildren().addAll(title, blurb);
        }
        */

    }
    
    
    private TreeItem<String> newBranch(String name, TreeItem<String> parent){
        TreeItem<String>  item = new TreeItem<>(name);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
    
     private void headerText(String s){
        Text intro = new Text(s+"\n");
        intro.setFont(Font.font("Calibri", FontWeight.BOLD, 26));
        textFlow.getChildren().add(intro);
    }
     
     private void bodyText(String s){
        Text intro = new Text(s+"\n");
        intro.setFont(Font.font("Calibri", FontWeight.BOLD, 26));
        textFlow.getChildren().add(intro);
    }
}


