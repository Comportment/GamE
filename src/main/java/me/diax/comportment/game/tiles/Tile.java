package me.diax.comportment.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 16:17
 * If you don't understand this, we are screwed.
 */
public class Tile {

    protected BufferedImage image;
    private final int id;
    public static final int WIDTH = 60, HEIGHT = 60;

    public Tile(BufferedImage image, int id) {
        this.image = image;
        this.id = id;
        TileManager.tiles[id] = this;
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