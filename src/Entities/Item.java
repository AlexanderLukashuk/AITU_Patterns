package Entities;

import java.util.ArrayList;

public abstract class Item {
    public String Name;
    public int Price;
    public ArrayList<String> Features;

    public Item() { }

    public Item(String name, int price) {
        Name = name;
        Price = price;
        Features = new ArrayList<>();
    }

    public void SetName(String name) {
        Name = name;
    }

    public void SetPrice(int price) {
        Price = price;
    }

    public String GetName() {
        return Name;
    }

    public int GetPrice() {
        return Price;
    }
}
