package me.diax.comportment.game.graphics;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.entity.Entity;
import me.diax.comportment.game.tiles.Tile;

/**
 * Created by Comportment on 10/06/2017 at 17:08
 * If you don't understand this, we are screwed.
 */
public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBorders() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > handler.getWorld().getWidth() * Tile.WIDTH - handler.getWidth()) {
            xOffset = handler.getWorld().getWidth() * Tile.WIDTH - handler.getWidth();
        }
        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getWorld().getHeight() * Tile.HEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * Tile.HEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getGame().getDimension().width / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getGame().getDimension().height / 2 + e.getHeight() / 2;
        checkBorders();
    }

    public void move(float xAmount, float yAmount) {
        xOffset += xAmount;
        yOffset += yAmount;
        checkBorders();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBorders();
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBorders();
    }
}