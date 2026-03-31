package org.example.inputs;

import org.example.basics.GameFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener {

    private boolean leftPressed;
    private boolean rightPressed;
    private boolean middlePressed;

    /**
     * Updates button state when a mouse button is pressed.
     * The switch maps the event's button code to the correct flag.
     *
     * @param e mouse event with button info.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Update the appropriate flag based on which button was pressed.
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftPressed = true;
            case MouseEvent.BUTTON2 -> middlePressed = true;
            case MouseEvent.BUTTON3 -> rightPressed = true;
            default -> { }
        }
    }

    /**
     * Updates button state when a mouse button is released.
     * This clears the same flag that was set in mousePressed.
     *
     * @param e mouse event with button info.
     */
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
    /**
     * Unused click callback kept to satisfy MouseListener.
     *
     * @param e mouse event.
     */
    @Override public void mouseClicked(MouseEvent e) {}
    /**
     * Unused enter callback kept to satisfy MouseListener.
     *
     * @param e mouse event.
     */
    @Override public void mouseEntered(MouseEvent e) {}
    /**
     * Unused exit callback kept to satisfy MouseListener.
     *
     * @param e mouse event.
     */
    @Override public void mouseExited(MouseEvent e) {}

    /**
     * @return true if left mouse button is currently pressed.
     */
    public boolean isLeftPressed() {return leftPressed;}
    /**
     * @return true if right mouse button is currently pressed.
     */
    public boolean isRightPressed() {return rightPressed;}
    /**
     * @return true if middle mouse button is currently pressed.
     */
    public boolean isMiddlePressed() {return middlePressed;}

}
