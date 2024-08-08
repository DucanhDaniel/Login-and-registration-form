package jfx.cmnbtwcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class RegisterController {

    public TextField usernameLabel;
    public PasswordField passwordLabel;
    public PasswordField rePasswordLabel;
    public Button registerBtn;
    public Label messageLabel;
    public TextField fullNameField;
    public ToggleGroup Gender;
    public RadioButton Male;
    public RadioButton Female;
    public RadioButton Unknown;
    public DatePicker dateOfBirthField;

    private String gender = "Male";
    private String dateOfBirth = "";

    public void getDateOfBirth(ActionEvent event) {
        LocalDate date = dateOfBirthField.getValue();
        dateOfBirth = date.toString();
    }
    public void register(ActionEvent event) throws IOException {
        // TODO: Implement register logic here
        String username = usernameLabel.getText();
        String password = passwordLabel.getText();
        String rePassword = rePasswordLabel.getText();
        String fullName = fullNameField.getText();

        if (Male.isSelected()) gender = "Male";
        if (Female.isSelected()) gender = "Female";
        if (Unknown.isSelected()) gender = "Unknown";


        if (password.equals(rePassword) && !username.isEmpty() &&!password.isEmpty() && !fullName.isEmpty()) {
            User user = new User(username, password, fullName, dateOfBirth, gender);
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

                System.out.println("Registering user...");
                System.out.println("Register successfully!");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Full Name: " + fullName);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("Gender: " + gender);

                stage.setTitle("Register successfully!");
                stage.show();
            } catch (IllegalArgumentException e) {
                messageLabel.setText(e.getMessage());
            }
        } else {
            if (!password.equals(rePassword))
                messageLabel.setText("Passwords do not match.");
            if (username.isEmpty())
                messageLabel.setText("Username is empty.");
            if (password.isEmpty())
                messageLabel.setText("Password is empty.");
            if (fullName.isEmpty())
                messageLabel.setText("Full name is empty.");
            if (dateOfBirth.isEmpty())
                messageLabel.setText("Date of birth field is empty.");
        }

    }

}
