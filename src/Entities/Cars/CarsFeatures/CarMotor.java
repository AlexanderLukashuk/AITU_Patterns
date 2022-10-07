package Entities.Cars.CarsFeatures;

import Decorator.CarDecorator;
import Entities.Car;

public class CarMotor extends CarDecorator {

    public CarMotor(Car car){
        super(car);
    }

    @Override
    public int GetCost() {
        return 0;
    }

    @Override
    public String getVoucher() {
        return "Comfort ";
    }

    @Override
    public int getPrice() {
        return Price + 1000;
    }
}
