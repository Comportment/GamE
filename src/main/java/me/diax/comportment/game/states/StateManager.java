package me.diax.comportment.game.states;

/**
 * Created by Comportment on 10/06/2017 at 15:13
 * If you don't understand this, we are screwed.
 */
public class StateManager {

    private static State state = null;

    public static void setState(State state) {
        StateManager.state = state;
    }

    public static State getState() {
        return state;
    }
}
