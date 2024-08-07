package jfx.cmnbtwcontroller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ImageShowController {
    public Button switchBtn;
    public ImageView imageView;

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
    }
}
