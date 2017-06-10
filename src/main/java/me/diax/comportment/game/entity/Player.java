package me.diax.comportment.game.entity;

import me.diax.comportment.game.graphics.Assets;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:37
 * If you don't understand this, we are screwed.
 */
public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) x, (int) y, null);
    }
}