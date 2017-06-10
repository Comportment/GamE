package me.diax.comportment.game.graphics;

import me.diax.comportment.game.Game;
import me.diax.comportment.game.entity.Entity;

/**
 * Created by Comportment on 10/06/2017 at 17:08
 * If you don't understand this, we are screwed.
 */
public class GameCamera {

    private float xOffset, yOffset;
    private Game game;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - game.getDimension().width / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getDimension().height / 2 + e.getHeight() / 2;
    }

    public void move(float xAmount, float yAmount) {
        xOffset += xAmount;
        yOffset += yAmount;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
