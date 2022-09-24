package Entities;

public class Item {
    public String Name;
    public int Price;

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
