package me.diax.comportment.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 14:19
 * If you don't understand this, we are screwed.
 */
public class Assets {

    public static final int width = 30, height = 30;

    public static BufferedImage
            PLAYER, ENEMY,
            GRASS, DIRT, STONE,
            WATER, LAVA,
            HARD_ROCK;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));

        PLAYER = sheet.crop(0, 0, width, height);
        ENEMY = sheet.crop(width, 0, width, height);
        GRASS = sheet.crop(0, height, width, height);
        DIRT = sheet.crop(width, height, width, height);
        STONE = sheet.crop(width * 2, height, width, height);
        WATER = sheet.crop(0, height * 2, width, height);
        LAVA = sheet.crop(width, height * 2, width, height);
        HARD_ROCK = sheet.crop(0, height * 3, width, height);
    }
}