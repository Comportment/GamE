package me.diax.comportment.game.entity;

import me.diax.comportment.game.Game;
import me.diax.comportment.game.graphics.Assets;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:37
 * If you don't understand this, we are screwed.
 */
public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.WIDTH, Creature.HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) (x - game.getCamera().getxOffset()), (int) (y - game.getCamera().getyOffset()), width, height, null);
    }

    public void getInput() {
        yMove = 0;
        xMove = 0;

        if (game.getKeyManager().up) yMove = -speed;
        if (game.getKeyManager().down) yMove = speed;
        if (game.getKeyManager().left) xMove = -speed;
        if (game.getKeyManager().right) xMove = speed;
    }
}