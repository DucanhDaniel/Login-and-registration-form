package jfx.cmnbtwcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    public PasswordField passwordLabel;
    public Button loginBtn;
    public TextField usernameLabel;
    public Label titleLabel;
    public Label messageLabel;
    public Button registerBtn;

    public void login(ActionEvent event) throws IOException {
        // TODO: Implement login logic here
        String password = passwordLabel.getText();
        String username = usernameLabel.getText();
        User user = new User(username, password);
        if (UserData.loginOK(user)) {
            //TODO: Switch to welcome scene
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("WelcomeScene.fxml")));
            Parent root = loader.load();
            WelcomeController controller = loader.getController();
            controller.displayWelcomeMessage(username);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            //TODO: Implement CSS for welcome scene
            String css = Objects.requireNonNull(this.getClass().getResource("WelcomeSceneCSS.css")).toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.setTitle("Welcome!");
            stage.show();
        }
        else {
            //Show login failed:
            messageLabel.setText("Login failed! Please check your username and password.");
        }

    }
    public void register(ActionEvent event) throws IOException {
        //TODO: Switch to register scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegisterScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        //TODO: Implement CSS for register scene
        String css = Objects.requireNonNull(this.getClass().getResource("RegisterSceneCSS.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Register form");
        stage.show();
    }
}