package me.diax.comportment.game.states;

import me.diax.comportment.game.Handler;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:10
 * If you don't understand this, we are screwed.
 */
public abstract class State {

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}