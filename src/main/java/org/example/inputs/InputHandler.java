package org.example.inputs;

import org.example.basics.GameFrame;
import org.example.shop.Money;

import java.awt.event.KeyEvent;

public class InputHandler{
    public KeyInput keyInput;
    private GameFrame gameFrame;

    public InputHandler(KeyInput keyInput, GameFrame gameFrame) {
        this.keyInput = keyInput;
        this.gameFrame = gameFrame;
    }

    public void handleInput() {
        if (keyInput.isKeyPressed(KeyEvent.VK_P)) {
            gameFrame.switchMenu = false;
            gameFrame.magnetButton.setVisible(false);
            gameFrame.weaponButton.setVisible(false);
        }

        if (keyInput.isKeyPressed(KeyEvent.VK_O)) {
            gameFrame.player.isHurt = false;
            gameFrame.switchMenu = true;
            gameFrame.magnetButton.setVisible(true);
            gameFrame.weaponButton.setVisible(true);
            gameFrame.gameWon = false;
            gameFrame.player.hasWeapon = false;
            gameFrame.player.hasMagnet = false;
            gameFrame.player.playerSpeed = 3;
            gameFrame.player.resetPosition();
            gameFrame.enemy.resetPosition(gameFrame.enemies);
            gameFrame.enemy.spawnEnemies(gameFrame.enemies);
            Money.spawnMoney(gameFrame.coins);
            gameFrame.budget = 0;
        }

    }
}
