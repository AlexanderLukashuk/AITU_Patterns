package Entities.Cars;

import Decorator.CarDecorator;
import Entities.Car;
import Interfaces.ICar;

public class SportCar extends Car {

    private Car car;

    public SportCar(Car car) {
        super(car);
    }

    public SportCar(String name, int price) {
        super(name, price);
    }


    @Override
    public int GetCost() {
        return car.GetCost() + 1000;
    }

//    @Override
//    public int getPrice(int price) {
//        return Price;
//    }

    @Override
    public int getPrice() {
        return Price;
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
