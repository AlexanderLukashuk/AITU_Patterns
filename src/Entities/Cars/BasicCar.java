package Entities.Cars;

import Decorator.CarDecorator;
import Entities.Car;

public class BasicCar extends Car {


    public BasicCar(String name, int price) {
        super(name, price);
    }

    @Override
    public int GetCost() {
        return 0;
    }

    @Override
    public int getPrice() {
        return Price;
    }
}
