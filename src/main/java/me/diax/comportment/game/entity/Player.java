package me.diax.comportment.game.entity;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.graphics.Assets;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:37
 * If you don't understand this, we are screwed.
 */
public class Player extends Creature {

    private Handler handler;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.WIDTH, Creature.HEIGHT);
        this.handler = handler;
        bounds.width = 59;
        bounds.height = 59;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGame().getCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) (x - handler.getGame().getCamera().getxOffset()), (int) (y - handler.getGame().getCamera().getyOffset()), width, height, null);
    }

    public void getInput() {
        yMove = 0;
        xMove = 0;

        if (handler.getGame().getKeyManager().up) yMove = - speed;
        if (handler.getGame().getKeyManager().down) yMove = speed;
        if (handler.getGame().getKeyManager().left) xMove = - speed;
        if (handler.getGame().getKeyManager().right) xMove = speed;
    }
}