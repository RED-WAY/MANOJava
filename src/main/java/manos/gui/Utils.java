package manos.gui;

import java.awt.Color;
import javax.swing.JComponent;

public class Utils {

    public void animateColor(JComponent component, Color end, String type, Integer delay) {

        new Thread(() -> {
            try {
                int r = type.equals("back")
                        ? component.getBackground().getRed()
                        : component.getForeground().getRed();

                int g = type.equals("back")
                        ? component.getBackground().getGreen()
                        : component.getForeground().getGreen();

                int b = type.equals("back")
                        ? component.getBackground().getBlue()
                        : component.getForeground().getBlue();

                int a = type.equals("back")
                        ? component.getBackground().getAlpha()
                        : component.getForeground().getAlpha();

                Color start = type.equals("back")
                        ? component.getBackground()
                        : component.getForeground();

                while (!start.equals(end)) {

                    if (r != end.getRed()) {
                        r = r > end.getRed() ? r - 1 : r + 1;
                    }
                    if (g != end.getGreen()) {
                        g = g > end.getGreen() ? g - 1 : g + 1;
                    }
                    if (b != end.getBlue()) {
                        b = b > end.getBlue() ? b - 1 : b + 1;
                    }
                    if (a != end.getAlpha()) {
                        a = a > end.getAlpha() ? a - 1 : a + 1;
                    }

                    start = new Color(r, g, b, a);

                    if (type.equals("back")) {
                        component.setBackground(start);
                    } else {
                        component.setForeground(start);
                    }
                    Thread.sleep(delay);
                }

                Thread.currentThread().interrupt();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }).start();

    }

}
