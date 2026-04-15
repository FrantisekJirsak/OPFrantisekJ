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
    private int startX = x;
    private int startY = y;
    private boolean hasWeapon = false;
    public boolean hasMagnet = true;
    public int money = 0;
    private int score = 0;

    private final Image PLAYER_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();
    private final Image PLAYER_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image PLAYER_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image PLAYER_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();

    private Image currentImage = PLAYER_1;

    public Player(int x, int y, KeyInput keyInput) {
        super(x, y);
        this.keyInput = keyInput;
        this.startX = startX;
        this.startY = startY;
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

    public void onBorders(Player player, Enemy enemy){
        if (player.getBounds().intersects(enemy.getBounds())){
            isHurt = true;
        }


    }

    public void resetPosition(){
        this.x = startX;
        this.y = startY;
    }

    public void setGainedMagnet(boolean hasMagnet) {
        this.hasMagnet = hasMagnet;
    }

    public void keepOut(){
        getBounds();
        if (y <= 100){
            y += 3;
        }

        if (x >= 1200){
            x -= 3;
    }

        if (y >= 800){
            y -= 3;
        }

        if (x <= 100){
            x += 3;


    }

    }

}








