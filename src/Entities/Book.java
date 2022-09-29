package Entities;

import Interfaces.ActionsInterfaces.IRead;
import Interfaces.MyCollectionInterfaces.CreativeActivity;

public class Book extends CreativeActivity implements IRead {

    public int NumberOfPages;

    public Book() {}

    public Book(String name, int price) {
        super(name, price);
    }

    public Book(String name, int price, String genre, String desc) {
        super(name, price, genre, desc);
    }

    @Override
    public void Read() {
        System.out.println("Intensive reading");
    }
}
