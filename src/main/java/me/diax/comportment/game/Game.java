package me.diax.comportment.game;

import me.diax.comportment.game.display.Display;
import me.diax.comportment.game.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

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

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private long nano = 1000000000;

    private int x = 1;


    public Game(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
    }

    private void init() {
        Assets.init();
        this.display = new Display(title, dimension);
    }

    private void tick() {
        x++;
    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, dimension.width, dimension.height);

        graphics.drawImage(Assets.dirt, x, 10, null);

        bufferStrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = nano / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= nano) {
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
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
        if (! running) return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}