package Decorator;

import Entities.Game;
import Interfaces.IGame;

public class GameDecorator implements IGame {

    protected IGame MyGame;

    public GameDecorator(IGame game) {
        MyGame = game;
    }

    @Override
    public void StartGame() {
        this.MyGame.StartGame();
    }
}
