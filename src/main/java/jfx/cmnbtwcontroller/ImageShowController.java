package jfx.cmnbtwcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ImageShowController {
    public Button switchBtn;
    public ImageView imageView;
    public Button returnButton;
    public CheckBox addMoreCbx;
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView img4;

    int counter = 0;
    Image myImage1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("aris-dancing-arisu-blue-archive.gif")));
    Image myImage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("blue-archive-bluesechi.gif")));
    public void displayImage() {
        counter = (counter + 1) % 2;
        Image myImage;
        if (counter == 0) {
            myImage = myImage1;
        }
        else {
            myImage = myImage2;
        }
        imageView.setImage(myImage);

        //TODO: Display button to return to welcome scene
        returnButton.setVisible(true);

    }
    public void switchToWelcomeScene(ActionEvent event) throws IOException {
        //TODO: Switch to welcome scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WelcomeScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Welcome!");
        stage.show();
    }

    public void cbxController(ActionEvent actionEvent) {
        if (addMoreCbx.isSelected()) {
            System.out.println("Adding more images");
            img1.setVisible(true);
            img2.setVisible(true);
            img3.setVisible(true);
            img4.setVisible(true);
        }
        else {
            System.out.println("Removing images");
            img1.setVisible(false);
            img2.setVisible(false);
            img3.setVisible(false);
            img4.setVisible(false);
        }
    }
}
