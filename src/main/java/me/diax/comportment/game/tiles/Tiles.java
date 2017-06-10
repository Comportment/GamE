package me.diax.comportment.game.tiles;

import me.diax.comportment.game.tiles.liquid.LavaTile;
import me.diax.comportment.game.tiles.liquid.WaterTile;
import me.diax.comportment.game.tiles.nonsolid.DirtTile;
import me.diax.comportment.game.tiles.nonsolid.GrassTile;
import me.diax.comportment.game.tiles.nonsolid.StoneTile;
import me.diax.comportment.game.tiles.solid.HardRockTile;

/**
 * Created by Comportment on 10/06/2017 at 16:24
 * If you don't understand this, we are screwed.
 */
public class Tiles {

    public static Tile[] TILES = new Tile[256];
    public static Tile GRASS = new GrassTile(0);
    public static Tile DIRT = new DirtTile(1);
    public static Tile STONE = new StoneTile(2);
    public static Tile WATER = new WaterTile(3);
    public static Tile LAVA = new LavaTile(4);
    public static Tile HARD_ROCK = new HardRockTile(5);
}