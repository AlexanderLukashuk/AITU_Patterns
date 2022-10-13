package Entities;

public abstract class Item {
    public String Name;
    public int Price;

    public Item() { }

    public Item(String name, int price) {
        Name = name;
        Price = price;
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
