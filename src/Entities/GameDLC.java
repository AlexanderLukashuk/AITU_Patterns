package Entities;

import Decorator.GameDecorator;
import Interfaces.IGame;

public class GameDLC extends GameDecorator {

    public GameDLC(IGame game) {
        super(game);
    }

    @Override
    public void StartGame() {
        System.out.println("Welcome to DLC");
    }
}
