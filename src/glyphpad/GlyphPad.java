/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Justin McKeown
 */
public class GlyphPad extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {

            ClassLoader cl = ClassLoader.getSystemClassLoader();
            URL[] urls = ((URLClassLoader) cl).getURLs();
            for (URL url : urls) {
                System.out.println("url is " + url.getFile());
            }

            Parent root = FXMLLoader.load(getClass().getResource("PredicateLogicPad.fxml"));
            Scene scene = new Scene(root);
            root.getStylesheets().add("glyphpad/styles/glyphpad.css");
            Stage stage = new Stage();
            stage.setTitle("Glyph Pad");
            stage.setScene(scene);
            //stage.getIcons().add(new Image(this.getClass().getResourceAsStream("icons/icon.png")));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(GlyphPad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
