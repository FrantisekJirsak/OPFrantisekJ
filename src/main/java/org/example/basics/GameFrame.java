package org.example.basics;

import org.example.characters.Enemy;
import org.example.characters.Entita;
import org.example.characters.Player;
import org.example.gamefield.Background;
import org.example.inputs.KeyInput;
import org.example.inputs.MouseInput;
import org.example.menu.Button;
import org.example.shop.Magnet;
import org.example.shop.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

import static java.awt.Color.lightGray;

public class GameFrame extends JPanel {


    private static final int timeDelay = 16;
    private final MouseInput mouseInput = new MouseInput(this);
    private final KeyInput keyInput = new KeyInput();
    Player player = new Player(100,800, keyInput);
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Money> coins = new ArrayList<>();
    int budget = 0;
    Magnet magnet = new Magnet("Magnet", 1);
    Weapon weapon = new Weapon("Shotgun", 2);
    JButton magnetButton = new JButton();
    JButton weaponButton = new JButton();
    Button button = new Button();
    Background background = new Background(this);
    private boolean switchMenu = false;
    private int shootCooldown = 0;
    static ArrayList<Entita> bulletList = new ArrayList<>();
    private final Image BULLET_RIGHT = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_right.png"))).getImage();
    private final Image BULLET_LEFT = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_left.png"))).getImage();
    private final Image BULLET_UP = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_up.png"))).getImage();
    private final Image BULLET_DOWN = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_down.png"))).getImage();
    public GameFrame(){

        setFocusable(true);
        addKeyListener(keyInput);
        addMouseListener(mouseInput);
        requestFocusInWindow();

        for (Enemy enemy : enemies){
            enemy.spawnEnemies();
        }

            new Timer(timeDelay,  e -> {
            if (!player.isHurt){
                repaint();

                player.movePlayer();

                player.keepOut();

                for (Enemy enemy : enemies){
                    enemy.moveEnemy();
                }

                for (Money coin : coins) {
                    coin.animateMoney();
                    if (coin.checkCollected(player.getBounds())) {
                        budget += 1;
                    }
                }

                if (player.hasMagnet){
                    for (Money money : coins) {
                        money.attractToPlayer(player, 150, 4);
                    }
                    magnet.animateMagnet(player);
                    player.setGainedMagnet(true);
                    magnet.deactivateWeapon(player);
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_P)){
                    switchMenu = false;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_O)){
                    switchMenu = true;
                    player.resetPosition();
                    Money.spawnMoney(coins);
                    budget = 0;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_U)){
                    player.hasMagnet = true;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_J)){
                    player.hasWeapon = true;
                }

                weapon.directWeapon(keyInput);

                nabojMove();

                if (keyInput.isKeyPressed(KeyEvent.VK_L) && shootCooldown == 0) {
                    naboj();
                    shootCooldown = 10;
                }
            }

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

    public void naboj(){
        if (player.hasWeapon){
            int dx = 0;
            int dy = 0;
            int offsetX = 0;
            int offsetY = 0;

            switch (player.direction){
                case "UP" -> {
                    dy = -5;
                    offsetY = -80;
                }
                case "DOWN" -> {
                    dy = 5;
                    offsetY = 80;
                }
                case "LEFT" -> {
                    dx = -5;
                    offsetX = -80;
                }
                case "RIGHT" -> {
                    dx = 5;
                    offsetX = 100;
                }
            }

            bulletList.add(new Entita(player.getX() + offsetX, player.getY() + offsetY, dx, dy));
            weapon.deactivateMagnet(player);

        }

    }

    private void nabojMove(){
        bulletList.forEach(Entita::move);
    }

    private void paintGame(Graphics g){
        background.drawBackground(g);
        magnet.drawMagnet(g, player);
        weapon.drawWeapon(g, player);
        player.drawPlayer(g);
        for (Money coin : coins) {
            coin.draw(g);
        }

        for (Enemy enemy : enemies){
            enemy.drawEnemies(g);
        }

        for (Entita naboj : bulletList){
            if (naboj.dx > 0) {
                g.drawImage(BULLET_RIGHT, naboj.x, naboj.y, null);
            } else if (naboj.dx < 0) {
                g.drawImage(BULLET_LEFT, naboj.x, naboj.y, null);
            } else if (naboj.dy < 0) {
                g.drawImage(BULLET_UP, naboj.x, naboj.y, null);
            } else if (naboj.dy > 0) {
                g.drawImage(BULLET_DOWN, naboj.x, naboj.y, null);
            }

        }
        g.drawString("Press P for Main Menu", 20,20);
        g.drawString("Good Luck", 630,20);
        g.drawString("Money:" + budget, 1220, 20);
        g.setColor(lightGray);

    }

    public boolean isSwitchMenu() {
        return switchMenu;
    }
}
