package me.diax.comportment.game.states;

import me.diax.comportment.game.Game;
import me.diax.comportment.game.entity.Player;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 15:11
 * If you don't understand this, we are screwed.
 */
public class GameState extends State {

    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}