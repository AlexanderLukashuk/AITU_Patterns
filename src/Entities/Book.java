package Entities;

import Interfaces.ActionsInterfaces.IRead;

public class Book extends Item implements IRead {
    public int NumberOfPages;

    @Override
    public void Read() {
        System.out.println("Intensive reading");
    }
}
