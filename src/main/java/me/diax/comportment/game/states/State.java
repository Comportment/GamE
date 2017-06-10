package me.diax.comportment.game.states;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.Renderable;
import me.diax.comportment.game.Tickable;

/**
 * Created by Comportment on 10/06/2017 at 15:10
 * If you don't understand this, we are screwed.
 */
public abstract class State implements Tickable, Renderable {

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }
}