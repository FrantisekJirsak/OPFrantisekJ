package org.example.inputs;

import org.example.basics.GameFrame;
import org.example.characters.Player;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

    private boolean leftPressed;
    private boolean rightPressed;
    private boolean middlePressed;
    GameFrame gameFrame;
    Player player;

    public MouseInput(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Update the appropriate flag based on which button was pressed.
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftPressed = true;
            case MouseEvent.BUTTON2 -> middlePressed = true;
            case MouseEvent.BUTTON3 -> rightPressed = true;
            default -> { }
        }

        int x1 = e.getX();
        int y = e.getY();

        Rectangle magnetHitbox = new Rectangle(200,10,100,100);
        Rectangle weaponHitbox = new Rectangle(900,10,100,100);

        if (magnetHitbox.contains(x1, y)) {
            player.hasMagnet = true;
        }

        if (weaponHitbox.contains(x1, y)) {
            player.hasWeapon = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Clear the appropriate flag when the button is released.
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftPressed = false;
            case MouseEvent.BUTTON2 -> middlePressed = false;
            case MouseEvent.BUTTON3 -> rightPressed = false;
            default -> { }
        }
    }

    @Override public void mouseClicked(MouseEvent e) {
        gameFrame.naboj();

    }

    @Override public void mouseEntered(MouseEvent e) {}

    @Override public void mouseExited(MouseEvent e) {}

    public boolean isLeftPressed() {return leftPressed;}

    public boolean isRightPressed() {return rightPressed;}

    public boolean isMiddlePressed() {return middlePressed;}

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
