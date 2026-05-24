package org.example.menu;

import org.example.basics.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class Button{
    public boolean isApproached = true;
    private final Image BUTTON_1 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/buttons/start_button_1.png"))).getImage();
    private final Image BUTTON_2 = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/buttons/start_button_2.png"))).getImage();

    private final Rectangle bounds = new Rectangle(50, 350, 256, 144);

    public void drawButton(Graphics g){
        if (!isApproached){
            g.drawImage(BUTTON_1, 50,350, null);
        } else {
            g.drawImage(BUTTON_2, 50, 355, null);
        }

    }

    public void updateHover(int mouseX, int mouseY) {
        isApproached = bounds.contains(mouseX, mouseY);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isApproached() {
        return isApproached;
    }

}
