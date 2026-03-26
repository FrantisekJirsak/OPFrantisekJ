package org.example.basics;

import org.example.characters.Enemy;
import org.example.characters.Player;
import org.example.gamefield.Background;
import org.example.inputs.KeyInput;
import org.example.menu.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameFrame extends JPanel {


    private static final int timeDelay = 16;
    private final KeyInput keyInput = new KeyInput();
    Player player = new Player(60,800, keyInput);
    Enemy enemy;
    ArrayList<Enemy> enemies = new ArrayList<>();
    Button button = new Button();
    Background background = new Background(this);
    private boolean switchMenu = false;
    public GameFrame(){

        setFocusable(true);
        addKeyListener(keyInput);
        requestFocusInWindow();

        new Timer(timeDelay, e -> {

            player.movePlayer();
            player.onBorders();



            if (keyInput.isKeyPressed(KeyEvent.VK_P)){
                switchMenu = !switchMenu;
            }

            System.out.println(switchMenu);




            repaint();
        }).start();
    }


    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (switchMenu){
            paintGame(g);
        } else {
            paintMenu(g);
        }

    }

    private void paintMenu(Graphics g){
        background.drawBackground(g);
        button.drawButton(g);
    }

    private void paintGame(Graphics g){
        background.drawBackground(g);
        player.drawPlayer(g);
        enemy.spawnEnemies();




    }


    public boolean isSwitchMenu() {
        return switchMenu;
    }
}
