package me.diax.comportment.game.states;

import me.diax.comportment.game.graphics.Assets;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:11
 * If you don't understand this, we are screwed.
 */
public class GameState extends State {

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.dirt, 0, 0, null);
    }
}