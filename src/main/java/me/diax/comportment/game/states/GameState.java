package me.diax.comportment.game.states;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.entity.Player;
import me.diax.comportment.game.worlds.World;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:11
 * If you don't understand this, we are screwed.
 */
public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "/worlds/2.world");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        player.render(graphics);
    }
}