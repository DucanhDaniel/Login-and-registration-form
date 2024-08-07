package jfx.cmnbtwcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterSuccessController {

    public Button returnLoginBtn;
    public void handleReturnLogin(ActionEvent event) throws IOException {
        //TODO: Implement action for return to login page (scene1)
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        //TODO: Implement CSS for login scene
        String css = Objects.requireNonNull(this.getClass().getResource("LoginSceneCSS.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();

    }
}
