package jfx.cmnbtwcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WelcomeController {

    public Label welcomeLabel;
    public Button imageSetBtn;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane scenePane;

    public void displayWelcomeMessage(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    Stage stage;

    public void logout(ActionEvent event) throws IOException  {
        //TODO: Show alert to confirm logout
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Confirmation logout");
        alert.setContentText("Are you sure you want to logout?");
        alert.showAndWait();

        //TODO: Switch to login scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        //TODO: Implement CSS for login scene
        String css = Objects.requireNonNull(this.getClass().getResource("LoginSceneCSS.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Login form");
        stage.show();
    }

    public void switchToImageShow(ActionEvent event) throws IOException {
        //TODO: Switch to image show scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ImageShowScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Image Show!");
        stage.show();
    }

}
