package org.example.shop;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Magnet extends Item{

    private int animationTick = 0;
    private final int animationSpeed = 12;

    private final ImageIcon MAGNET1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_1.png")));
    private final ImageIcon MAGNET2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_2.png")));
    private final ImageIcon MAGNET3 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/magnets/magnet_frame_3.png")));

    private ImageIcon currentImage = MAGNET1;


    public Magnet(String name, int id) {
        int price = 10;
        super(name, id);
    }

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

    public static void showInStore(Graphics g){
        int x = 250;
        int y = 10;
        g.drawImage(curre)


    }


}
