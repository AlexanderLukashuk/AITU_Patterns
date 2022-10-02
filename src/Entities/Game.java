package Entities;

import Interfaces.IGame;
import Interfaces.MyCollectionInterfaces.CreativeActivity;

public class Game extends CreativeActivity implements IGame {

    public Game() {}

    public Game(String name, int price) {
        super(name, price);
    }

    @Override
    public void StartGame() {
        System.out.println("Welcome to " + this.Name);
    }
}
