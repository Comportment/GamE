package me.diax.comportment.game.entity;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:29
 * If you don't understand this, we are screwed.
 */
public abstract class Entity {

    protected float x, y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}