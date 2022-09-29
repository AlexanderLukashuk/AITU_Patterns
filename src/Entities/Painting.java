package Entities;

import Interfaces.MyCollectionInterfaces.CreativeActivity;

public class Painting extends CreativeActivity {

    public Painting() {}

    public Painting(String name, int price) {
        super(name, price);
    }

    public Painting(String name, int price, String genre, String desc) {
        super(name, price, genre, desc);
    }
}
