package org.example.characters;

import org.example.basics.GameFrame;
import org.example.inputs.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Player extends Entita{

    GameFrame gameFrame;
    private KeyInput keyInput;
    private int playerSpeed = 3;
    private boolean hasWeapon = false;
    private boolean hasItem = false;
    private boolean isMoving = false;

    private final Image PLAYER_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();
    private final Image PLAYER_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image PLAYER_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image PLAYER_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();

    private Image currentImage = PLAYER_1;

    public Player(int x, int y, KeyInput keyInput) {
        super(x, y);
        this.keyInput = keyInput;
    }


    public void drawPlayer(Graphics g){
        g.drawImage(currentImage, x, y, null);


    }

    public void movePlayer(){
        if (keyInput.isKeyPressed(KeyEvent.VK_W)){
            y -= playerSpeed;
            currentImage = PLAYER_1;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_S)){
            y += playerSpeed;
            currentImage = PLAYER_2;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_A)){
            x -= playerSpeed;
            currentImage = PLAYER_3;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_D)){
            x += playerSpeed;
            currentImage = PLAYER_4;
        }

        }

    public void onBorders(){
        if (x <= 0){
            x = x + playerSpeed;
        }

        if (x >= 1300){
            x = x - playerSpeed;
        }

        if (y <= 0){
            y = y + playerSpeed;

        }

        if (y <= 900){
            y = y - playerSpeed;
    }


    }

}






