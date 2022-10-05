package Entities;

import Decorator.CarDecorator;
import Interfaces.ICar;

public class SportCar extends CarDecorator {

    private Car car;

    public SportCar(Car car) {
        super(car);
    }


    @Override
    public int GetCost() {
        return car.GetCost() + 1000;
    }

    //
////    public SportCar(ICar car) {
////        super(car);
////    }
//
//    public SportCar(ICar car) {
//        super(car);
//    }
//
//    @Override
//    public void Assemble() {
//        super.Assemble();
//        System.out.println(" Adding features of Sport Car ");
//    }
}
