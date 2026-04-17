package org.example.characters;

import org.example.basics.GameFrame;
import org.example.inputs.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Player extends Entita{

    private KeyInput keyInput;
    private int playerSpeed = 3;
    private int startX = x;
    private int startY = y;
    public boolean hasWeapon = true;
    public boolean obtainedWeapon = false;
    public boolean obtainedMagnet = false;
    public boolean hasMagnet = true;
    public String direction = "UP";
    int dx;
    int dy;

    private final Image PLAYER_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();
    private final Image PLAYER_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image PLAYER_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image PLAYER_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();

    private Image currentImage = PLAYER_1;

    public Player(int x, int y, KeyInput keyInput) {
        super(x, y, 0,0);
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
            direction = "UP";
            currentImage = PLAYER_1;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_S)){
            y += playerSpeed;
            direction = "DOWN";
            currentImage = PLAYER_2;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_A)){
            x -= playerSpeed;
            direction = "LEFT";
            currentImage = PLAYER_3;
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_D)){
            x += playerSpeed;
            direction = "RIGHT";
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








