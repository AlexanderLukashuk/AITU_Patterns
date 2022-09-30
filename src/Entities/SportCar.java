package Entities;

import Decorator.CarDecorator;
import Interfaces.ICar;

public class SportCar extends CarDecorator {

    public SportCar(ICar car) {
        super(car);
    }

    @Override
    public void Assemble() {
        super.Assemble();
        System.out.println(" Adding features of Sport Car ");
    }
}
