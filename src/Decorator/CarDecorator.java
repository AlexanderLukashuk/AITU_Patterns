package Decorator;

import Entities.Car;
import Interfaces.ICar;

public class CarDecorator implements ICar {

    protected ICar Car;

    public CarDecorator(Car car) {
        Car = car;
    }

    @Override
    public void Assemble() {
        this.Car.Assemble();
    }
}
