package me.diax.comportment.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Comportment on 10/06/2017 at 15:43
 * If you don't understand this, we are screwed.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;

    public void tick() {
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
    }

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}