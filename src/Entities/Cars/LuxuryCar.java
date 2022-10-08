package Entities.Cars;

import Decorator.CarDecorator;
import Entities.Car;
import Interfaces.ICar;

public class LuxuryCar extends Car {

    private Car car;

    public LuxuryCar(Car car) {
        super(car);
    }

    public LuxuryCar(String name, int price) {
        super(name, price);
    }


    @Override
    public int GetCost() {
        return car.GetCost() + 2000;
    }

//    @Override
//    public int getPrice(int price) {
//        return Price;
//    }

    @Override
    public int getPrice() {
        return Price;
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
