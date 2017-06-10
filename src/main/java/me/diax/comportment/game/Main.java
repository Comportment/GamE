package me.diax.comportment.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Comportment on 10/06/2017 at 11:17
 * If you don't understand this, we are screwed.
 */
public class Main {

    public static void main(String[] args) {
        new Main().main();
    }

    public void main() {
        JFrame frame = new JFrame("GamE");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(getIcon());
        frame.setResizable(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public Image getIcon() {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/icon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}