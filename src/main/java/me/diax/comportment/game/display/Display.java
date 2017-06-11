package me.diax.comportment.game.display;

import me.diax.comportment.game.graphics.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 13:27
 * If you don't understand this, we are screwed.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private Dimension dimension;

    public Display(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
        this.createDisplay();
    }

    public Display(String title, int width, int height) {
        this.title = title;
        this.dimension = new Dimension(width, height);
        this.createDisplay();
    }


    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setFocusable(false);

        frame.setIconImage(ImageLoader.loadImage("/icon.jpg"));
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}