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

                if (player.hasMagnet) {
                    for (Money money : coins) {
                        money.attractToPlayer(player, 150, 4); // radius = 150px, speed = 4
                    }
                }

                if (player.hasMagnet){
                    magnet.animateMagnet(player);
                    player.setGainedMagnet(true);
                    magnet.deactivateWeapon(player);
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_P)){
                    switchMenu = false;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_U)){
                    player.hasWeapon = true;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_J)){
                    player.hasMagnet = true;
                }

                if (keyInput.isKeyPressed(KeyEvent.VK_O)){
                    switchMenu = true;
                    player.resetPosition();
                    Money.spawnMoney(coins);
                    budget = 0;
                }

                nabojMove();

                if (keyInput.isKeyPressed(KeyEvent.VK_L) && shootCooldown == 0) {
                    naboj();
                    shootCooldown = 10;
                }



                System.out.println(player.hasMagnet);

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
            bulletList.add(new Entita(player.x, player.y));
            weapon.deactivateMagnet(player);
        }

    }

    private void nabojMove(){
        bulletList.forEach(i -> i.y += 5);
    }

    private void paintGame(Graphics g){
        background.drawBackground(g);
        magnet.drawMagnet(g, player);
        player.drawPlayer(g);
        for (Money coin : coins) {
            coin.draw(g);
        }

        for (Enemy enemy : enemies){
            enemy.drawEnemies(g);
        }

        for (Entita naboj : bulletList){
            g.drawImage(BULLET_DOWN, naboj.getX(), naboj.getY(), null);
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
