package me.diax.comportment.game.worlds;

import me.diax.comportment.game.Handler;
import me.diax.comportment.game.Renderable;
import me.diax.comportment.game.Tickable;
import me.diax.comportment.game.tiles.Tile;
import me.diax.comportment.game.tiles.Tiles;
import me.diax.comportment.game.utils.Utils;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 16:28
 * If you don't understand this, we are screwed.
 */
public class World implements Tickable, Renderable {

    private int width, height, spawnX, spawnY;
    private int[][] tiles;
    private Handler handler;

    public World(Handler handler, String path) {
        this.handler = handler;
        this.loadWorld(path);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics graphics) {
        int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getGame().getDimension().getWidth()) / Tile.WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getGame().getDimension().getHeight()) / Tile.HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(graphics, (int) (x * Tile.WIDTH - handler.getCamera().getxOffset()), (int) (y * Tile.HEIGHT - handler.getCamera().getyOffset()));
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
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tiles.DIRT;
        }
        Tile t = Tiles.TILES[tiles[x][y]];
        if (t == null) return Tiles.TILES[0];
        return t;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}