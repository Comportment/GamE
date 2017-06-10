package me.diax.comportment.game.tiles.solid;

import me.diax.comportment.game.graphics.Assets;
import me.diax.comportment.game.tiles.Tile;

/**
 * Created by Comportment on 10/06/2017 at 20:36
 * If you don't understand this, we are screwed.
 */
public class HardRockTile extends Tile {

    public HardRockTile(int id) {
        super(Assets.HARD_ROCK, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}