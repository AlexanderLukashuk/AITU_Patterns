package Entities.Cars;

import Decorator.CarDecorator;
import Entities.Car;
import Interfaces.ICar;

public class LuxuryCar extends CarDecorator {

    private Car car;

    public LuxuryCar(Car car) {
        super(car);
    }


    @Override
    public int GetCost() {
        return car.GetCost() + 2000;
    }

//    public LuxuryCar(ICar car) {
//        super(car);
//    }
//    public LuxuryCar(ICar car) {
//        super(car);
//    }
//
//    @Override
//    public void Assemble() {
//        super.Assemble();
//        System.out.println(" Adding features of Luxury Car ");
//    }
}
