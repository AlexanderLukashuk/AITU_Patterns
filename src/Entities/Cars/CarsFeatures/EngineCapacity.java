package Entities.Cars.CarsFeatures;

import Decorator.CarDecorator;
import Entities.Car;

public class EngineCapacity extends CarDecorator {

    public EngineCapacity(Car car){
        super(car);
    }

    @Override
    public String getVoucher() {
        return "Sport Car";
    }

    @Override
    public int getPrice() {
        return Price + 500;
    }
}
