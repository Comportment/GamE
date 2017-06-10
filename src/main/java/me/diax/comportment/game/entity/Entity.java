package me.diax.comportment.game.entity;

import me.diax.comportment.game.Game;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:29
 * If you don't understand this, we are screwed.
 */
public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Game game;

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}