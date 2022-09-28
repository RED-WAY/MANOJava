package manos.views.utils;

// resizeImage()
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

// initImages()
import manos.views.exceptions.ArraySizesIncompatibleException;

public class ImageManipulator {

    private int labelsQuantity;

    public ImageManipulator(int labelsQuantity) {
        this.labelsQuantity = labelsQuantity;
    }

    public int getLabelsQuantity() {
        return labelsQuantity;
    }

    public ImageIcon resizeImage(JLabel label, String imagePath) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(String.format("assets/%s", imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        return imageIcon;
    }

    public void initImages(JLabel[] labels, String[] images) {
        try {
            if (labels.length != images.length) {
                throw new ArraySizesIncompatibleException("Array sizes differ");
            }

            for (int i = 0; i < labelsQuantity--; i++) {
//                System.out.println(labels[i]);
                labels[i].setIcon(resizeImage(labels[i], images[i]));
            }
        } catch (ArraySizesIncompatibleException e) {
            e.printStackTrace();
        }
    }
}
