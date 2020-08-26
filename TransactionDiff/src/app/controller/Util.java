package app.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is a utility class that provides common methods.
 */
public class Util {
    /**
     * Switch the current scene.
     * @param stage current stage
     * @param path new scene path
     * @throws IOException if the view wasn't found
     */
    public static void switchScene(Stage stage, String path) throws IOException {
        Parent root = FXMLLoader.load(Util.class.getResource(path));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
