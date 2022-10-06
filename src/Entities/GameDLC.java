package Entities;

import Decorator.GameDecorator;
import Interfaces.IGame;

public class GameDLC extends GameDecorator {

    public GameDLC(Game game) {
        super(game);
    }

    public GameDLC(String name, int price) {
        super(name, price);
    }

    @Override
    public void StartGame() {
        System.out.println("Welcome to DLC");
    }
}
