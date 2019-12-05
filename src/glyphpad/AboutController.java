/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Justin McKeown
 */
public class AboutController implements Initializable {

    @FXML TextArea aboutText;
    @FXML Text title; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setText("GlyphPad Beta 0.0.0.1");
        aboutText.setText("GlyphPad has been devleoped as a lightweight tool for writing propositional logic and basic set theory. What more can I say. Enjoy.");
    }    
    
}
