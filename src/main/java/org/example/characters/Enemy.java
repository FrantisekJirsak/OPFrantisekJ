package org.example.characters;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entita {
    private int moveSpeed = 1;
    Player player;

    public Enemy(int x, int y, Player player) {
        super(x, y, player.dx, player.dy);
        this.player = player;
    }

    private final Image ENEMY_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_4.png"))).getImage();
    private final Image ENEMY_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_3.png"))).getImage();
    private final Image ENEMY_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_2.png"))).getImage();
    private final Image ENEMY_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/characters/mc_soldier_1.png"))).getImage();

    private Image currentImage = ENEMY_1;

    public void drawEnemies(Graphics g) {
        g.drawImage(currentImage, x, y, null);
    }

    public void moveEnemy() {
        if (player.x > x) {
            x += moveSpeed;
            currentImage = ENEMY_1;
        }
        if (player.x < x) {
            x -= moveSpeed;
            currentImage = ENEMY_2;
        }
        if (player.y > y) {
            y += moveSpeed;
            currentImage = ENEMY_3;
        }
        if (player.y < y) {
            y -= moveSpeed;
            currentImage = ENEMY_4;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 64);
    }

}
