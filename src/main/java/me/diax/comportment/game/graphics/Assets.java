package me.diax.comportment.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 14:19
 * If you don't understand this, we are screwed.
 */
public class Assets {

    public static final int width = 30, height = 30;

    public static BufferedImage player, enemy, dirt, stone;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));

        player = sheet.crop(0, 0, width, height);
        enemy = sheet.crop(0, height, width, height);
        stone = sheet.crop(width, 0, width, height);
        dirt = sheet.crop(width, height, width, height);
    }
}
