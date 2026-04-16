package org.example.shop;

import org.example.basics.GameFrame;
import org.example.characters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Weapon extends Item{
    public Weapon(String name, int id) {
        int price = 30;
        super(name, id);
    }

    private int xInShop = 900;
    private int yInShop = 10;

    private final Image WEAPON_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png"))).getImage();
    private final Image WEAPON_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png"))).getImage();
    private final Image WEAPON_3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png"))).getImage();
    private final Image WEAPON_4 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png"))).getImage();
    private final Image WEAPON_SHOW = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_show_in_store.png"))).getImage();


    private final Image currentImage = WEAPON_1;



    public void drawWeapon(Graphics g, Player player){
        if (player.hasWeapon){
            int offsetX = 40;
            int offsetY = 0;
            g.drawImage(currentImage, player.x + offsetX, player.y + offsetY, null);
        } else {
            g.drawImage(WEAPON_SHOW, xInShop, yInShop, null);
        }

    }

    public void deactivateMagnet(Player player){
        if (player.hasWeapon){
            player.hasMagnet = false;
        }
    }
}
