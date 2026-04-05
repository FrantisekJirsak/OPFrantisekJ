package org.example.basics;


import org.example.menu.MenuPanel;

import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        setTitle("Gunfire Mission");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,900);

        GameFrame gameFrame = new GameFrame();
        add(gameFrame);

        setLocationRelativeTo(null);
        setVisible(true);

        if (gameFrame.isSwitchMenu()){
            MenuPanel menuPanel = new MenuPanel(() -> {
                System.out.println("Good Luck!");

            });

        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Game::new);
    }


}
