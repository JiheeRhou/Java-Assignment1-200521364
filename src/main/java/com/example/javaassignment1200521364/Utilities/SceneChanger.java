package com.example.javaassignment1200521364.Utilities;

import com.example.javaassignment1200521364.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Scene Changer class
 *
 * @author Ji Hee Rhou
 */
public class SceneChanger {
    /**
     * This is a method to change the scene
     * @param actionEvent
     * @param fxmlFileName
     * @param viewTitle
     * @throws IOException
     */
    public static void changeScene(ActionEvent actionEvent, String fxmlFileName, String viewTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(viewTitle);
        stage.setScene(scene);
        stage.show();
    }
}
