package me.diax.comportment.game;

import javax.swing.*;

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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }
}