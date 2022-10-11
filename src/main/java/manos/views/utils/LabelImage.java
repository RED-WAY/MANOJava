package manos.views.utils;

import javax.swing.JLabel;

public class LabelImage {

    private JLabel label;
    private String imagePath;

    public LabelImage(JLabel label, String imagePath) {
        this.label = label;
        this.imagePath = imagePath;
    }
    
    public JLabel getLabel() {
        return this.label;
    }
    public String getImagePath() {
        return this.imagePath;
    }
}
