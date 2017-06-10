package me.diax.comportment.game.graphics;

import me.diax.comportment.game.Tickable;

import java.awt.image.BufferedImage;

/**
 * Created by Comportment on 10/06/2017 at 21:22
 * If you don't understand this, we are screwed.
 */
public class Animation implements Tickable {

    private int speed, index;
    private long lastTick, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        this.timer = 0;
        this.lastTick = System.currentTimeMillis();
    }

    @Override
    public void tick() {
        timer += System.currentTimeMillis() - lastTick;
        lastTick = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) index = 0;
        }
    }

    public BufferedImage getFrame() {
        return frames[index];
    }
}