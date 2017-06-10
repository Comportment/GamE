package me.diax.comportment.game.tiles;

/**
 * Created by Comportment on 10/06/2017 at 16:24
 * If you don't understand this, we are screwed.
 */
public class TileManager {

    public static Tile[] tiles = new Tile[256];
    public static Tile dirtTile = new DirtTile(0);
    public static Tile stoneTile = new StoneTile(1);

}
