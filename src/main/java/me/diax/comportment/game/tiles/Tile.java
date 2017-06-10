package me.diax.comportment.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 16:17
 * If you don't understand this, we are screwed.
 */
public class Tile {

    public static final int WIDTH = 60, HEIGHT = 60;
    private final int id;
    protected BufferedImage image;

    public Tile(BufferedImage image, int id) {
        this.image = image;
        this.id = id;
        Tiles.TILES[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }
}