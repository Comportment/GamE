package me.diax.comportment.game;

import me.diax.comportment.game.graphics.GameCamera;
import me.diax.comportment.game.input.KeyManager;
import me.diax.comportment.game.worlds.World;

/**
 * Created by Comportment on 10/06/2017 at 17:41
 * If you don't understand this, we are screwed.
 */
public class Handler {

    private Game game;
    private World world;


    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getCamera() {
        return game.getCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public int getWidth() {
        return game.getDimension().width;
    }

    public int getHeight() {
        return game.getDimension().height;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}