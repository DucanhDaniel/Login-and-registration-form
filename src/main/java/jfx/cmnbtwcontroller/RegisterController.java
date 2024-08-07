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

public class RegisterController {

    public TextField usernameLabel;
    public PasswordField passwordLabel;
    public PasswordField rePasswordLabel;
    public Button registerBtn;
    public Label messageLabel;

    public void register(ActionEvent event) throws IOException {
        // TODO: Implement register logic here
        String username = usernameLabel.getText();
        String password = passwordLabel.getText();
        String rePassword = rePasswordLabel.getText();

        if (password.equals(rePassword)) {
            User user = new User(username, password);
            try {
                UserData.addUser(user);
                //TODO: Switch to Register Successfully scene
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegisterSuccessScene.fxml")));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                //TODO: Implement CSS for RegisterSuccessfully scene
                String css = Objects.requireNonNull(this.getClass().getResource("RegisterSuccessSceneCSS.css")).toExternalForm();
                scene.getStylesheets().add(css);

                stage.setTitle("Register successfully!");
                stage.show();

            } catch (IllegalArgumentException e) {
                messageLabel.setText(e.getMessage());
            }
        } else {
            messageLabel.setText("Passwords do not match!");
        }
    }

}
