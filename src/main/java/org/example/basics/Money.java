package org.example.basics;

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
        if (currentImage == COIN1) {
            currentImage = COIN2;
        }

        if (currentImage == COIN2) {
            currentImage = COIN3;
        }

        if (currentImage == COIN3) {
            currentImage = COIN1;
        }
    }

    public static void spawnMoney(ArrayList<Money> coins) {
        Random random = new Random();
        coins.clear();

        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(100, 1300);
            int y = random.nextInt(100, 800);

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

}
