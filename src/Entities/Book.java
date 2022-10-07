package Entities;

import Interfaces.ActionsInterfaces.IRead;
import Interfaces.MyCollectionInterfaces.CreativeActivity;

public abstract class Book extends CreativeActivity implements IRead {

    public int NumberOfPages;

    public Book() {}

    public Book(String name, int price) {
        super(name, price);
    }

    public Book(String name, int price, String genre, String desc) {
        super(name, price, genre, desc);
    }

    public Book(Book iBook) {
        Name = iBook.Name;
        Price = iBook.Price;
    }

    @Override
    public void Read() {
        System.out.println("Intensive reading");
    }

    public String getVoucher() {
        return "Features:";
    }
    public int getPrice() {
        return Price;
    }

    public void setPrice() { }
}
