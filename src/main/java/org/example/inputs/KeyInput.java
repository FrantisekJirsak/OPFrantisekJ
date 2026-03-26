package org.example.inputs;

import org.example.characters.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * Tracks keyboard key states for gameplay input.
 * The array index equals the KeyEvent key code; true means the key is down.
 *
 * How it works: Swing calls keyPressed/keyReleased when the user interacts
 * with the keyboard. We store that information in an array so the game loop
 * can "poll" the current state inside updateGame() (instead of reacting directly
 * in the event callback).
 */
public class KeyInput implements KeyListener {
    // State of keys indexed by key code (true = pressed).
    private boolean[] keys = new boolean[256];


    /**
     * Unused key typed callback kept to satisfy KeyListener.
     *
     * @param e key event.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Marks a key as pressed.
     * It uses the key code as an index and stores true in the array.
     *
     * @param e key event with key code.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Arrays.fill(keys, false);

        keys[e.getKeyCode()] = true;
    }

    /**
     * Marks a key as released.
     * It uses the key code as an index and stores false in the array.
     *
     * @param e key event with key code.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // Record the released state for this key code.
        keys[e.getKeyCode()] = false;
    }

    /**
     * Returns the internal key state array.
     *
     * @return array indexed by key code; true means pressed.
     */
    public boolean[] getKeys() {
        return keys;
    }

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

}