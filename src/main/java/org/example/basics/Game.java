package org.example.basics;

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
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Game::new);
    }



}
