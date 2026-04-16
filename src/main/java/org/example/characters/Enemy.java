package org.example.characters;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entita {
    private int moveSpeed = 2;
    ArrayList<Enemy> enemies = new ArrayList<>();
    Player player;

    public Enemy(int x, int y, Player player) {
        super(x, y);
        this.player = player;
    }

    private final Image ENEMY_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();
    private final Image ENEMY_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image ENEMY_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image ENEMY_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();

    private Image currentImage = ENEMY_1;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void drawEnemies(Graphics g){
        for (Entita enemy : enemies){
            g.drawImage(currentImage, enemy.x, enemy.y, null);
        }

    }



    public void moveEnemy(){
        for (Enemy enemy : enemies){
            if (player.x > enemy.x){
                enemy.x += moveSpeed;
                currentImage = ENEMY_1;
            }
            if (player.x < enemy.x){
                enemy.x -= moveSpeed;
                currentImage = ENEMY_2;
            }
            if (player.y > enemy.y){
                enemy.y += moveSpeed;
                currentImage = ENEMY_3;
            }
            if (player.y < enemy.y){
                enemy.y -= moveSpeed;
                currentImage = ENEMY_4;
            }

        }

    }

    public void spawnEnemies() {
        for (int i = 0; i < 49; i++){
            Random random = new Random();
            int x = random.nextInt(500, 1200);
            int y = random.nextInt(100, 200);
            enemies.add(new Enemy(x,y));
        }
    }





    }







