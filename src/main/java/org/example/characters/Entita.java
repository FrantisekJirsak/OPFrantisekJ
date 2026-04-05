package org.example.characters;

import org.example.basics.Money;

public class Entita {

    public int x,y;
    public boolean isHurt = false;

    public Entita(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void getBounds(Money money, Enemy enemy){
        if (x >= enemy.x){
            isHurt = true;
        }

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
