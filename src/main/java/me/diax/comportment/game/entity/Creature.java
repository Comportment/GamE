package me.diax.comportment.game.entity;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.tiles.Tile;

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

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = Creature.BASE_SPEED;
        health = Creature.BASE_HEALTH;
        yMove = 0;
        xMove = 0;
    }

    public static int getBaseHealth() {
        return BASE_HEALTH;
    }

    public static float getBaseSpeed() {
        return BASE_SPEED;
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        if (xMove > 0) {//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.WIDTH;

            if (! collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
                    ! collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.WIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) {//Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.WIDTH;

            if (! collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
                    ! collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.WIDTH + Tile.WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.HEIGHT;

            if (! collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
                    ! collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.HEIGHT + Tile.HEIGHT - bounds.y;
            }
        } else if (yMove > 0) {//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.HEIGHT;

            if (! collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
                    ! collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
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