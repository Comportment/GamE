package me.diax.comportment.game.states;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:10
 * If you don't understand this, we are screwed.
 */
public abstract class State {

    public abstract void tick();

    public abstract void render(Graphics graphics);
}