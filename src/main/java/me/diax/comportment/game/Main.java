package me.diax.comportment.game;

import me.diax.comportment.game.tiles.Tile;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 11:17
 * If you don't understand this, we are screwed.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game("GamE", new Dimension(Tile.WIDTH * 5, Tile.HEIGHT * 5));
        game.start();
    }
}