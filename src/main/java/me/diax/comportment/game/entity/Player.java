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
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeyManager().up) y -= 5;
        if (game.getKeyManager().down) y += 5;
        if (game.getKeyManager().left) x -= 5;
        if (game.getKeyManager().right) x += 5;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) x, (int) y, null);
    }
}