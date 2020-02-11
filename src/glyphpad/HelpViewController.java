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
import javax.xml.bind.ParseConversionEvent;

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
        helpTextStore = new HelpTextStore();
        
        
        double edgeBuffer = 20;
        scrollPane.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow.setMaxWidth((newValue.doubleValue()-edgeBuffer));
            }  
        });
        
        //Set up help menu
        TreeItem<String> root, overview, glyphList, pLogicList, sTList, bracketList, arrowList, letters, subscripts, superscripts;
        root = new TreeItem<>();
        root.setExpanded(true);
        
        //Overview branch
        overview = newBranch("Overview", root);
        newBranch("Introduction", overview);
        newBranch("glyphCode Rules", overview);
        glyphList = newBranch("glyphCode Lists", overview);
        pLogicList = newBranch("Propositional Logic", glyphList);
        sTList = newBranch("Set Theory", glyphList);
        bracketList = newBranch("Brackets", glyphList);
        arrowList = newBranch("Arrows", glyphList);
        letters = newBranch("Letter like characters", glyphList);
        subscripts = newBranch("Subscripts", glyphList);
        superscripts = newBranch("Superscripts", glyphList);
        
        /*
        
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
        */
        
        
        
        //add the branches to the tree by setting the root
        helpMenu.setRoot(root);
        helpMenu.setShowRoot(false);
        helpMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("observable: "+observable);
            System.out.println("oldValue: "+oldValue);
            System.out.println("newValue: "+newValue.getValue());
            String search = newValue.getValue();
            
            //setView(newValue.getValue());
            switch(newValue.getValue()) {
                case "Introduction":
                    setView(helpTextStore.getIntroduction());
                    break;
                case "glyphCode Rules":
                    setView(helpTextStore.getIntroduction());
                    setView(helpTextStore.getGlyphcodeRules());
                    break;
                case "Propositional Logic":
                    setView(helpTextStore.getPlCodes());
                    break;
                case "Set Theory":
                    setView(helpTextStore.getStCodes());
                    break;
                case "Brackets":
                    setView(helpTextStore.getbCodes());
                    break;
                case "Arrows":
                    setView(helpTextStore.getaCodes());
                    break;
                case "Letter like characters":
                    setView(helpTextStore.getLetterCodes());
                    break;
                case "Subscripts":
                    setView(helpTextStore.getSubscripts());
                    break;
                case "Superscripts":
                    setView(helpTextStore.getSuperscripts());
                    break;
                default:
                    System.out.println("Default Case called. input: "+ newValue.getValue());
                    break;
            }
            });
        
        //set the initial view to the Introductino text
        setView(helpTextStore.getIntroduction());
        
    }
    
    private void setView(LinkedHashMap<String, String> map){
        textFlow.getChildren().clear();
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().contains("title")){
                textFlow.getChildren().add(TextFormatUtility.headerText(entry.getValue(), "\n"));
            }else if(entry.getKey().contains("blurb")){
                textFlow.getChildren().add(TextFormatUtility.bodyText(entry.getValue()));
            }
            else{
                textFlow.getChildren().add(TextFormatUtility.headerTwoText(entry.getKey()));
                textFlow.getChildren().add(TextFormatUtility.bodyText(entry.getValue()));
            }
        }   
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


