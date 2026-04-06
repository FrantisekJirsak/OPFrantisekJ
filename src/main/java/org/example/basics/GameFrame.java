package org.example.basics;

import org.example.characters.Enemy;
import org.example.characters.Player;
import org.example.gamefield.Background;
import org.example.inputs.KeyInput;
import org.example.inputs.MouseInput;
import org.example.menu.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static java.awt.Color.lightGray;

public class GameFrame extends JPanel {


    private static final int timeDelay = 16;
    private final MouseInput mouseInput = new MouseInput();
    private final KeyInput keyInput = new KeyInput();
    Player player = new Player(60,800, keyInput);
    Enemy enemyManager = new Enemy(getX(), getY());
    ArrayList<Enemy> enemies = new ArrayList<>();
    private int[] money;
    Button button = new Button();
    Background background = new Background(this);
    private boolean switchMenu = false;
    public GameFrame(){

        setFocusable(true);
        addKeyListener(keyInput);
        addMouseListener(mouseInput);
        requestFocusInWindow();
        enemyManager.spawnEnemies(enemyManager);


        new Timer(timeDelay, e -> {

            player.movePlayer();

            for (Enemy enemy : enemies){
                enemy.moveEnemy();
            }

            if (keyInput.isKeyPressed(KeyEvent.VK_P)){
                switchMenu = false;
            }

            if (keyInput.isKeyPressed(KeyEvent.VK_O)){
                switchMenu = true;
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
        g.drawString("Press P for Main Menu", 20,20);
        g.drawString("Money:" + Arrays.toString(money), 1220, 20);
        g.setColor(lightGray);
        enemyManager.drawEnemies(g);








    }

    public boolean isSwitchMenu() {
        return switchMenu;
    }
}
