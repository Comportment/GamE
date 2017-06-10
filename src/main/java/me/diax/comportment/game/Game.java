package me.diax.comportment.game;

import me.diax.comportment.game.display.Display;

import java.awt.*;

/**
 * Created by Comportment on 10/06/2017 at 13:41
 * If you don't understand this, we are screwed.
 */
public class Game implements Runnable {

    private Display display;
    private Dimension dimension;
    public String title;

    private Boolean running = false;
    private Thread thread;

    public Game(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
    }

    private void init() {
        this.display = new Display(title, dimension);
    }

    private void tick() {

    }

    private void render() {

    }

    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}