/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
    
    HelpTextStore helpTextStore;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        textFlow.setMaxWidth(800);

        LinkedHashMap<String, String> propositionalLogicText;
        LinkedHashMap<String, String> setTheoryText;

        helpTextStore = new HelpTextStore();
        propositionalLogicText = helpTextStore.getHelpText();
        setTheoryText = helpTextStore.getSetTheoryTextHelp();
        
        
        formatText(propositionalLogicText, setTheoryText);
        
        double edgeBuffer = 20;
        scrollPane.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow.setMaxWidth((newValue.doubleValue()-edgeBuffer));
            }
            
        });
        
    }    
    
    private void formatText(LinkedHashMap<String, String> propositionalLogic, LinkedHashMap<String, String> setTheory)  {

        
        Text intro = new Text("Overview: The basics of using GlyphPad.\n");
        intro.setFont(Font.font("Calibri", FontWeight.BOLD, 26));
        
        Text introBlurb = new Text("GlyphPad is designed to make writing propositional logic and basic set theory formulas much easier. "
                + "It achieves this thorugh the use of inutivitive three to four character shortcodes prefixed with a '\\'. "
                + "The three letters for each short code is derived from the first three letters of the word formally used for the given symbol. "
                + "For exmaple, the shortcode for the negation symbol is '\\neg'. If the user types this then the shortcode will be transformed into the negation symbol '¬'"
                + "\n\n"
                + "The full list of symbols currently included in GlyphPad are listed below along with their shortcodes. It is advised you take a moment to read these as it will "
                + "help you use the app. Under each symbol the related laws of propositional logic have also been listed for convenience.\n\n");
        introBlurb.setFont(Font.font("Calibri", FontWeight.MEDIUM, 24));
                
        Text propHeading = new Text("1.Propositional Logic: short codes and Laws:\n");
        propHeading.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        
        textFlow.getChildren().addAll(intro, introBlurb, propHeading);
        
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

    }
}


