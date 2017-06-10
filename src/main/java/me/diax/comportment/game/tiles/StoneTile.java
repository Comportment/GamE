package me.diax.comportment.game.tiles;

import me.diax.comportment.game.graphics.Assets;

/**
 * Created by Comportment on 10/06/2017 at 16:21
 * If you don't understand this, we are screwed.
 */
public class StoneTile extends Tile {

    public StoneTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}