package org.example.gamefield;

import org.example.basics.GameFrame;
import org.example.inputs.KeyInput;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Background {
    private GameFrame gameFrame;
    private final Image BACKGROUND = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/background/guntime_mission_background.png"))).getImage();
    private final Image MENU_BACKGROUND = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/menu/guntime_mission_menu.png"))).getImage();

    public Background(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }


    public void drawBackground(Graphics g){
        if (!gameFrame.isSwitchMenu()){
            g.drawImage(MENU_BACKGROUND, 0,0,null);
        } else {
            g.drawImage(BACKGROUND, 0, 0, null);
        }

    }
}
