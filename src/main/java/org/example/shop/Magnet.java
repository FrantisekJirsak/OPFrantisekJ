package org.example.shop;

import org.example.basics.GameFrame;
import org.example.characters.Entita;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Magnet extends Item{

    public Magnet(String name, int id) {
        int price = 10;
        super(name, id);
    }

    private int xInShop = 300;
    private int yInShop = 10;
    private boolean gainedMagnet = false;
    Entita player;

    private int animationTick = 0;
    private final int animationSpeed = 12;

    private final Image MAGNET1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png"))).getImage();
    private final Image MAGNET2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_2.png"))).getImage();
    private final Image MAGNET3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_3.png"))).getImage();
    private final Image MAGNET_SHOW = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_show_in_store.png"))).getImage();

    private Image currentImage = MAGNET1;


    public void animateMagnet(){
        animationTick++;

        if (animationTick >= animationSpeed) {
            animationTick = 0;

            if (currentImage == MAGNET1) {
                currentImage = MAGNET2;
            } else if (currentImage == MAGNET2) {
                currentImage = MAGNET3;
            } else {
                currentImage = MAGNET1;
            }
        }

    }

    public void activateMagnet(){
        if (gainedMagnet){

        }
    }

    public void showMagnetInStore(Graphics g){
        if (gainedMagnet){
            g.drawImage(currentImage, xInShop, yInShop, null);
        } else {
            g.drawImage(MAGNET_SHOW, xInShop, yInShop, null);
        }





    }


}
