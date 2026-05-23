package org.example.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyInput implements KeyListener {
    private boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Arrays.fill(keys, false);

        keys[e.getKeyCode()] = true;

        if (isKeyPressed(KeyEvent.VK_L) && gameframe.shootCooldown == 0) {
            weapon.naboj(gameframe.player, gameframe.bulletList, weapon);
            gameframe.shootCooldown = 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public boolean[] getKeys() {
        return keys;
    }

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

}