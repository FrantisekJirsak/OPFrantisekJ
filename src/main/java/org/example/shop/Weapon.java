package org.example.shop;

import org.example.basics.GameFrame;
import org.example.characters.Enemy;
import org.example.characters.Entita;
import org.example.characters.Player;
import org.example.inputs.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

public class Weapon extends Item{


    private int xInShop = 900;
    private int yInShop = 10;

    private final Image WEAPON_1 = new ImageIcon(requireNonNull(GameFrame.class.getResource("/weapons/shotgun_frame_1.png"))).getImage();
    private final Image WEAPON_2 = new ImageIcon(requireNonNull(GameFrame.class.getResource("/weapons/shotgun_frame_2.png"))).getImage();
    private final Image WEAPON_3 = new ImageIcon(requireNonNull(GameFrame.class.getResource("/weapons/shotgun_frame_3.png"))).getImage();
    private final Image WEAPON_4 = new ImageIcon(requireNonNull(GameFrame.class.getResource("/weapons/shotgun_frame_4.png"))).getImage();
    private final Image WEAPON_IN_STORE = new ImageIcon(requireNonNull(GameFrame.class.getResource("/weapons/weapon_show_in_store.png"))).getImage();


    private Image currentImage = WEAPON_1;

    public Weapon(String name, int id, int price) {
        super(name, id, price);
    }


    public void drawWeapon(Graphics g, Player player){
        if (player.hasWeapon){
            int offsetX = 40;
            int offsetY = 0;

            switch (player.direction){
                case "RIGHT" -> {
                    currentImage = WEAPON_1;
                    offsetX = 40;
                    offsetY = 0;
                }
                case "LEFT" -> {
                    currentImage = WEAPON_2;
                    offsetX = -40;
                    offsetY = 0;
                }
                case "UP" -> {
                    currentImage = WEAPON_3;
                    offsetX = 10;
                    offsetY = -30;
                }
                case "DOWN" -> {
                    currentImage = WEAPON_4;
                    offsetX = 10;
                    offsetY = 30;
                }
            }

            g.drawImage(currentImage, player.x + offsetX, player.y + offsetY, null);
        } else {
            g.drawImage(WEAPON_IN_STORE, xInShop, yInShop, null);
        }

    }

    public void directWeapon(KeyInput keyInput){
        if (keyInput.isKeyPressed(KeyEvent.VK_A)){
            currentImage = WEAPON_2;

        }
         if (keyInput.isKeyPressed(KeyEvent.VK_D)){
             currentImage = WEAPON_1;
         }
    }

    public void deactivateMagnet(Player player){
        if (player.hasWeapon){
            player.hasMagnet = false;
        }
    }

    public void buyWeapon(Player player, GameFrame gameFrame) {
        if (gameFrame.budget >= 40) {
            gameFrame.budget -= 40;
            player.hasWeapon = true;
            player.hasMagnet = false;
        }
    }

    public void deleteBullet(Enemy enemy, ArrayList<Entita> bulletlist){
        for (Entita bullet : bulletlist){
            if (bullet.getBounds().intersects(enemy.getBounds())){
                bulletlist.remove(bullet);
            }
        }
    }
}
