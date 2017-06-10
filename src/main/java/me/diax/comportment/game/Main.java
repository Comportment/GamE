package me.diax.comportment.game;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 11:17
 * If you don't understand this, we are screwed.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game("GamE", new Dimension(300, 300));
        game.start();
    }
}