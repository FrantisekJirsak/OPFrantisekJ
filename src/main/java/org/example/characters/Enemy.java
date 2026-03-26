package org.example.characters;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entita {

    private int moveSpeed = 2;
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

    public void drawEnemy(Graphics g){
        for (int i = 0; i <= 49; i++){
            Enemy enemy = new Enemy(x, y);
            Random random = new Random();
            x = random.nextInt(1500, 2000);
            y = random.nextInt(-150, -300);
            enemies.add(enemy);


        }

    }

}





