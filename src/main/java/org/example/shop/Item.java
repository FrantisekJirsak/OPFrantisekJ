package org.example.shop;

import org.example.basics.GameFrame;
import org.example.menu.Button;

public class Item {
    String name;
    private GameFrame gameFrame;
    int id;
    int price;

    public Item(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public void checkMoney(GameFrame gameFrame, Button button){
    }

}
