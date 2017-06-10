package me.diax.comportment.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 14:11
 * If you don't understand this, we are screwed.
 */
public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return image.getSubimage(x, y, width, height);
    }
}
