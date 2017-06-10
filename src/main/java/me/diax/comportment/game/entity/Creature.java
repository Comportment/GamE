package me.diax.comportment.game.entity;

/**
 * Created by Comportment on 10/06/2017 at 15:35
 * If you don't understand this, we are screwed.
 */
public abstract class Creature extends Entity {

    public static final int BASE_HEALTH = 10;
    public static final float BASE_SPEED = 5.0f;
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;


    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        speed = Creature.BASE_SPEED;
        health = Creature.BASE_HEALTH;
        yMove = 0;
        xMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    public static int getBaseHealth() {
        return BASE_HEALTH;
    }

    public static float getBaseSpeed() {
        return BASE_SPEED;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}