package Entities.Cars.CarsFeatures;

import Decorator.CarDecorator;
import Entities.Car;

public class EngineCapacity extends CarDecorator {

    public EngineCapacity(Car car){
        super(car);
    }

    @Override
    public int GetCost() {
        return 0;
    }

    @Override
    public String getVoucher() {
        return "Sport Car";
    }

    @Override
    public int getPrice() {
//        this.Price = (int) price;
//        return price;

        return Price + 500;
    }
}
