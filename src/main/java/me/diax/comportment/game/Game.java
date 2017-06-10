package me.diax.comportment.game;

import me.diax.comportment.game.display.Display;
import me.diax.comportment.game.graphics.Assets;
import me.diax.comportment.game.graphics.GameCamera;
import me.diax.comportment.game.input.KeyManager;
import me.diax.comportment.game.states.GameState;
import me.diax.comportment.game.states.MenuState;
import me.diax.comportment.game.states.State;
import me.diax.comportment.game.states.StateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Comportment on 10/06/2017 at 13:41
 * If you don't understand this, we are screwed.
 */
public class Game implements Runnable {

    public String title;
    private Display display;
    private Dimension dimension;
    private Boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private long nano = 1000000000;

    private State gameState;
    private State menuState;

    private KeyManager keyManager;

    private GameCamera camera;
    private Handler handler;


    public Game(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
        keyManager = new KeyManager();
    }

    private void init() {
        Assets.init();
        this.display = new Display(title, dimension);
        display.getFrame().addKeyListener(keyManager);
        camera = new GameCamera(this, 0, 0);
        handler = new Handler(this);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        StateManager.setState(gameState);
    }

    private void tick() {
        keyManager.tick();
        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }
    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, dimension.width, dimension.height);

        if (StateManager.getState() != null) {
            StateManager.getState().render(graphics);
        }
        bufferStrategy.show();
        graphics.dispose();
    }

    public GameCamera getCamera() {
        return camera;
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

    public KeyManager getKeyManager() {
        return keyManager;
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

    public Dimension getDimension() {
        return dimension;
    }
}