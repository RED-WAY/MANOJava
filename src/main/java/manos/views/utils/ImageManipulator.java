package manos.views.utils;

// resizeImage()
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageManipulator {

    public ImageIcon resizeImage(JLabel label, String imagePath) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(String.format("src/main/resources/images/%s", imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        return imageIcon;
    }
}
