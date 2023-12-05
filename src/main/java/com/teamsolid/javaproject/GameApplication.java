package com.teamsolid.javaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The main class for the JavaFX application, responsible for launching and displaying the game window.
 * This class extends the Application class from JavaFX and sets up the initial scene for the game.
 *
 * @author Jingzhi_Zhou
 */
public class GameApplication extends Application {

    /**
     * Starts the JavaFX application. This method is called after the application is launched.
     * It sets up the primary stage (window) of the application, including loading the initial FXML,
     * setting the scene, and displaying the stage.
     *
     * @param stage The primary stage for this application, onto which the application scene can be set.
     *              Applications may create other stages if needed, but this is the main one.
     * @throws IOException If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("typename.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
        stage.setTitle("Game!");
        stage.show();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the launch method has returned, and after the system is ready for the application to begin running.
     *
     * @param args command line arguments passed to the application.
     *             An application may get these parameters using the getParameters() method.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
