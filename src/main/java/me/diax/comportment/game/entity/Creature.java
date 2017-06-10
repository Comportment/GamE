package me.diax.comportment.game.entity;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:35
 * If you don't understand this, we are screwed.
 */
public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }

    public Creature(float x, float y, int health) {
        super(x, y);
        this.health = health;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}