package me.diax.comportment.game.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 14:04
 * If you don't understand this, we are screwed.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}