package Decorator;

import Entities.Car;
import Interfaces.ICar;

//public class CarDecorator implements ICar {
public abstract class CarDecorator extends Car {

    protected Car MyCar;

    public CarDecorator(Car car) {
        super(car);
    }

    @Override
    public void Assemble() {
        this.MyCar.Assemble();
    }

    @Override
    public String GetCarName() {
        return this.MyCar.GetCarName();
    }

    @Override
    public String getVoucher() {
        return "Features:";
    }

    public abstract int getPrice();
}
