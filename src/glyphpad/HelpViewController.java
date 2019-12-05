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

        LinkedHashMap<String, String> helpText;

        helpTextStore = new HelpTextStore();
        helpText = helpTextStore.getHelpText();
        
        formatText(helpText);
        
        scrollPane.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //textFlow.setPrefWidth(oldValue.doubleValue());
                textFlow.setMaxWidth(newValue.doubleValue());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        //make it so that the textFlow warps to the size of the scroll-pane and when scrollpane changes size, textpane warps too.
        
    }    
    
    private void formatText(LinkedHashMap<String, String> m) {

        Text introduction = new Text("welcome to the help view. Below is a list of all the symbols currently supported by glphPad and the short codes used to create them while typing.\n");
        introduction.setFont(Font.font("Calibri", FontWeight.BOLD, 70));
        textFlow.getChildren().add(introduction);
        for (Map.Entry<String, String> entry : m.entrySet()) {

            Text title = new Text(entry.getKey() + "\n");
            title.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 100));

            Text blurb = new Text(entry.getValue() + "\n");
            title.setFont(Font.font("Calibri", FontWeight.MEDIUM, 70));
            textFlow.getChildren().addAll(title, blurb);
            //title = entry.getKey();
            //blurb = entry.getValue();
            //finalText += (title+"\n"+blurb+"\n");
        }

    }
}


