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
        
        developedBy.setText("Developed by Dr J. McKeown, 2019");
        /*
        
        Text txt = new Text("Feedback & comments: ");
        Hyperlink link = new Hyperlink("mail@glyph-pad.com");
        email.getChildren().addAll(txt, link);
        
        link.setOnAction((ActionEvent event) -> {
            System.out.println("Email link clicked");
            Desktop desktop;
        if (Desktop.isDesktopSupported()
                && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
            URI mailto = null;
            try {
                mailto = new URI("mailto:mail@glyph-pad.com");
            } catch (URISyntaxException ex) {
                Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                desktop.mail(mailto);
            } catch (IOException ex) {
                Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // TODO fallback to some Runtime.exec(..) voodoo?
            //throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
            Alert alrt = new Alert(Alert.AlertType.ERROR, "Error opening your default desktop email program. "
                    + "Try copying and pasting the link into your email program instead", ButtonType.OK);
            alrt.showAndWait();
        }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });
        */
    }    
    
    
    
    
}
