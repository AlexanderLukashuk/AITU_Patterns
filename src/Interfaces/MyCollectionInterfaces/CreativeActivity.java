package Interfaces.MyCollectionInterfaces;

import Entities.Item;

public abstract class CreativeActivity extends Item {
    public String Genre = "No genre";
    public String Description = "No description";

    public CreativeActivity() {}

    public CreativeActivity(String name, int price) {
        super(name, price);
    }

    public CreativeActivity(String name, int price, String genre, String desc) {
        super(name, price);
        Genre = genre;
        Description = desc;
    }

    public void SetGenre(String genre) {
        Genre = genre;
    }

    public String GetGenre() {
        return Genre;
    }

    public void SetDescription(String desc) {
        Description = desc;
    }

    public String GetDescription() {
        return Description;
    }
}
