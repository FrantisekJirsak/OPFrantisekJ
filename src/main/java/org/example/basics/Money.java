package org.example.basics;

import org.example.characters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Money {
    private int x;
    private int y;
    private boolean isCollected;

    private final ImageIcon COIN1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/money/money_frame_1.png")));
    private final ImageIcon COIN2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/money/money_frame_2.png")));
    private final ImageIcon COIN3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/money/money_frame_3.png")));

    private ImageIcon currentImage = COIN1;
    private int animationTick = 0;
    private final int animationSpeed = 12;

    public Money(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (!isCollected) {
            g.drawImage(currentImage.getImage(), x, y, null);
        }
    }

    public void animateMoney() {
        animationTick++;

        if (animationTick >= animationSpeed) {
            animationTick = 0;

            if (currentImage == COIN1) {
                currentImage = COIN2;
            } else if (currentImage == COIN2) {
                currentImage = COIN3;
            } else {
                currentImage = COIN1;
            }
        }
    }

    public static void spawnMoney(ArrayList<Money> coins) {
        Random random = new Random();
        coins.clear();

        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(100, 1100);
            int y = random.nextInt(100, 700);

            coins.add(new Money(x, y));
        }

    }

    public boolean checkCollected(Rectangle playerBounds) {
        Rectangle coinBounds = new Rectangle(x, y, 32, 32);

        if (!isCollected && playerBounds.intersects(coinBounds)) {
            isCollected = true;
            return true;
        }
        return false;
    }

    public void attractToPlayer(Player player, int radius, int speed) {
        double dx = player.x - this.x;
        double dy = player.y - this.y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < radius) {
            // normalize direction
            double directionX = dx / distance;
            double directionY = dy / distance;

            // move coin toward player
            this.x += directionX * speed;
            this.y += directionY * speed;
        }
    }

}
