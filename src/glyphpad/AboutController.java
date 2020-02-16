/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Justin McKeown
 */
public class AboutController implements Initializable {

    @FXML TextArea aboutText;
    @FXML Text title; 
    @FXML Text blurb;
    @FXML Text developedBy;
    @FXML TextFlow email; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        developedBy.setText("Developed by J. McKeown, 2019");
    
    }    
    
    
    
    
}
