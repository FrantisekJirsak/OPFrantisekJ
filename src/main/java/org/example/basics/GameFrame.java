package org.example.basics;

import org.example.characters.Enemy;
import org.example.characters.Entita;
import org.example.characters.Player;
import org.example.gamefield.Background;
import org.example.inputs.InputHandler;
import org.example.inputs.KeyInput;
import org.example.inputs.MouseInput;
import org.example.menu.Button;
import org.example.shop.Magnet;
import org.example.shop.Money;
import org.example.shop.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

import static java.awt.Color.lightGray;

public class GameFrame extends JPanel {


    private static final int timeDelay = 16;
    public final MouseInput mouseInput = new MouseInput();
    public final KeyInput keyInput = new KeyInput();
    public final InputHandler inputHandler = new InputHandler(keyInput, this);
    public Player player = new Player(100,800, keyInput);
    public ArrayList<Enemy> enemies = new ArrayList<>();
    public ArrayList<Money> coins = new ArrayList<>();
    ArrayList<Enemy> enemiesToRemove = new ArrayList<>();
    ArrayList<Entita> bulletsToRemove = new ArrayList<>();
    public int budget = 0;
    public Enemy enemy = new Enemy(getX(), getY(), player);
    Magnet magnet = new Magnet("Magnet", 1, 10);
    Weapon weapon = new Weapon("Shotgun", 2, 40);
    public JButton magnetButton = new JButton("Buy Magnet");
    public JButton weaponButton = new JButton("Buy Weapon");
    Button button = new Button();
    Background background = new Background(this);
    public boolean switchMenu = false;
    private int shootCooldown = 0;
    public static ArrayList<Entita> bulletList = new ArrayList<>();
    public boolean gameWon = false;
    private final Image BULLET_RIGHT = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_right.png"))).getImage();
    private final Image BULLET_LEFT = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_left.png"))).getImage();
    private final Image BULLET_UP = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_up.png"))).getImage();
    private final Image BULLET_DOWN = new ImageIcon(Objects.requireNonNull(GameFrame.class.getResource("/bullet/bullet_down.png"))).getImage();

    public GameFrame(){
        setFocusable(true);
        addKeyListener(keyInput);
        addMouseListener(mouseInput);
        requestFocusInWindow();
        magnetButton.addActionListener(e -> {
            magnet.buyMagnet(player, this);
            requestFocusInWindow();
        });

        weaponButton.addActionListener(e -> {
            weapon.buyWeapon(player, this);
            requestFocusInWindow();

        });

        add(magnetButton);
        add(weaponButton);
        magnetButton.setVisible(false);
        weaponButton.setVisible(false);
        enemy.spawnEnemies(enemies);


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

                for (Enemy enemy : enemies) {
                    weapon.deleteBullet(enemy, bulletList);
                    }

                }
                enemies.removeAll(enemiesToRemove);
            if (enemies.isEmpty() && !gameWon) {
                gameWon = true;
            }
                enemiesToRemove.clear(); // so enemies don't accumulate across frames

                enemies.removeAll(enemiesToRemove);
                bulletList.removeAll(bulletsToRemove);

                weapon.directWeapon(keyInput);

                weapon.nabojMove(bulletList);

                if (mouseInput.isLeftClicked() && shootCooldown == 0) {
                    Weapon.naboj(player, bulletList, weapon);
                    shootCooldown = 10;
                }

                for (Enemy enemy : enemies) {
                    boolean hit = bulletList.removeIf(bullet -> bullet.getBounds().intersects(enemy.getBounds()));
                    if (hit) {
                        enemiesToRemove.add(enemy);
                    }

                }

                if (shootCooldown > 0) {
                    shootCooldown--;
                }

                for (Enemy enemy : enemies) {
                    if (enemy.getBounds().intersects(player.getBounds())) {
                        player.isHurt = true;
                    }
                }

            inputHandler.handleInput();

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

        for (Enemy enemy : enemies){
            enemy.drawEnemies(g);
        }
        magnet.drawMagnet(g, player);
        weapon.drawWeapon(g, player);
        player.drawPlayer(g);
        for (Money coin : coins) {
            coin.drawMoney(g);
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
        g.drawString("Good Luck", 630,50);
        g.drawString("Money:" + budget, 1220, 20);
        g.setColor(lightGray);

        if (gameWon) {
            g.setFont(new Font("Arial", Font.BOLD, 72));
            g.setColor(Color.YELLOW);
            g.drawString("YOU WON!", 450, 450);

            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Press O to play again", 500, 520);
        } else {

        }

        if (player.isHurt){
            g.setFont(new Font("Arial", Font.BOLD, 72));
            g.setColor(Color.YELLOW);
            g.drawString("YOU LOSE!", 450, 450);

            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Press O to play again", 500, 520);
        }

    }

    public boolean isSwitchMenu() {
        return switchMenu;
    }
}