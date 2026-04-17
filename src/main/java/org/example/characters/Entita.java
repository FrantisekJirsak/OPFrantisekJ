package org.example.characters;

import java.awt.*;

public class Entita {

    public int x,y;
    public int dx, dy;
    public boolean isHurt = false;

    public Entita(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 48, 48);

    }

    public void move(){
        x += dx;
        y += dy;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHurt() {
        return isHurt;
    }

    public void setHurt(boolean hurt) {
        isHurt = hurt;
    }
}
