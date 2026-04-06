package org.example.characters;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entita {
    private int moveSpeed = 3;
    GameFrame gameFrame;
    ArrayList<Enemy> enemies = new ArrayList<>();
    Player player;

    private final Image ENEMY_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();
    private final Image ENEMY_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image ENEMY_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image ENEMY_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();

    private final Image currentImage = ENEMY_1;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void drawEnemies(Graphics g){
        for (Entita enemy : enemies){
            g.drawImage(currentImage, x, y, null);
        }

    }

    public void moveEnemy(){

            if (player.x > x){
                x += moveSpeed;
            }
            if (player.x < x){
                x -= moveSpeed;
            }
            if (player.y > y){
                y += moveSpeed;
            }
            if (player.y < y){
                y -= moveSpeed;
            }



    }

    public void spawnEnemies(Enemy enemy) {
        for (int i = 0; i < 49; i++){
            Random random = new Random();
            int x = random.nextInt(1000, 1200);
            int y = random.nextInt(100, 200);
            enemies.add(new Enemy(x, y));
        }
    }





    }







