package me.diax.comportment.game.worlds;

import me.diax.comportment.game.Game;
import me.diax.comportment.game.tiles.Tile;
import me.diax.comportment.game.tiles.TileManager;
import me.diax.comportment.game.utils.Utils;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 16:28
 * If you don't understand this, we are screwed.
 */
public class World {

    private int width, height, spawnX, spawnY;
    private int[][] tiles;
    private Game game;

    public World(Game game, String path) {
        this.game = game;
        this.loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics graphics) {
        int xStart = (int) Math.max(0, game.getCamera().getxOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width, (game.getCamera().getxOffset() + game.getDimension().width) / Tile.WIDTH + 1);
        int yStart = (int) Math.max(0, game.getCamera().getyOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height, (game.getCamera().getxOffset() + game.getDimension().height) / Tile.HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(graphics, (int) (x * Tile.WIDTH - game.getCamera().getxOffset()), (int) (y * Tile.HEIGHT - game.getCamera().getyOffset()));
            }
        }
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] objs = file.split("\\s+");
        width = Utils.parseInt(objs[0]);
        height = Utils.parseInt(objs[1]);
        spawnX = Utils.parseInt(objs[2]);
        spawnY = Utils.parseInt(objs[3]);
        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(objs[(x + y * width) + 4]);
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = TileManager.tiles[tiles[x][y]];
        if (t == null) return TileManager.tiles[0];
        return t;
    }
}
