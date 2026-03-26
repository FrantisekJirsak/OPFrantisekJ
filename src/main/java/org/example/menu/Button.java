package org.example.menu;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class Button{
    private boolean isApproached = true;
    GameFrame gameFrame;
    private final Image BUTTON_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/buttons/start_button_1.png"))).getImage();
    private final Image BUTTON_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/buttons/start_button_2.png"))).getImage();

    public void drawButton(Graphics g){
        if (!isApproached){
            g.drawImage(BUTTON_1, 50,350, null);
        } else {
            g.drawImage(BUTTON_2, 50, 355, null);
        }

    }

    public void checkBounds(MouseMotionListener e){



    }

}
