package jfx.cmnbtwcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        UserData.addUser(new User("admin", "admin", "Admin User", "1990-01-01", "Unknown"));

        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("LoginScene.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Login form");

        //TODO: Implement CSS for login scene
        String css = Objects.requireNonNull(this.getClass().getResource("LoginSceneCSS.css")).toExternalForm();
        scene.getStylesheets().add(css);

        //TODO: Show login scene
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume(); // Consume the event, so it won't close the window
            logout(stage);
        });
    }

    public void logout(Stage stage) throws NoSuchElementException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit. Are you sure?");
        alert.setContentText("Choose an option.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Exit successfully!");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}