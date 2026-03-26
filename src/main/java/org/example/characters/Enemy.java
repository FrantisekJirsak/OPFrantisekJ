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
    Player player;
    ArrayList<Entita> enemies = new ArrayList<>();

    private final Image ENEMY_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/background/guntime_mission_background.png"))).getImage();
    private final Image ENEMY_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/background/guntime_mission_background.png"))).getImage();
    private final Image ENEMY_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/background/guntime_mission_background.png"))).getImage();
    private final Image ENEMY_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/background/guntime_mission_background.png"))).getImage();

    private Image currentImage = ENEMY_1;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void moveEnemy(){
        for (Entita enemy : enemies){
            if (player.x > enemy.x){
                enemy.x = enemy.x - moveSpeed;
            }

            if (player.x < enemy.x){
                enemy.x = enemy.x + moveSpeed;
            }

            if (player.y > enemy.y){
                enemy.y = enemy.y + moveSpeed;
            }

            if (player.y < enemy.y){
                enemy.y = enemy.y - moveSpeed;
            }

        }

    }

    public void spawnEnemies(){
        Random random = new Random();

        for (int i = 0; i < 49; i++){
            int x = random.nextInt(1500, 2000);
            int y = random.nextInt(-300, -150);

            enemies.add(new Enemy(x, y));
        }
    }



    }







