package Decorator;

import Entities.Car;
import Interfaces.ICar;

//public class CarDecorator implements ICar {
public abstract class CarDecorator extends Car {

//    protected ICar Car;
    protected ICar MyCar;

//    public CarDecorator(ICar car) {
//        Car = car;
//    }
//    public CarDecorator(Car car) {
//        MyCar = car;
//    }

    public CarDecorator(Car car) {
        super(car);
    }

    public abstract int GetCost();

    @Override
    public void Assemble() {
        this.MyCar.Assemble();
    }

    @Override
    public String GetCarName() {
        return this.MyCar.GetCarName();
    }
}
