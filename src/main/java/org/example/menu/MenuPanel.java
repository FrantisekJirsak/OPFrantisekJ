package org.example.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(Runnable inGame){
        setLayout(new BorderLayout());

        JButton startButton = new JButton("Shotgun");
        startButton.setFont(new Font("Arial", Font.BOLD, 6));
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(100, 50));

        startButton.addActionListener(e -> {
            if (inGame != null) {
                inGame.run();
            }
        });

        add(startButton, BorderLayout.NORTH);

    }



}
