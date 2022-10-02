package Decorator;

import Entities.Car;
import Interfaces.ICar;

public class CarDecorator implements ICar {

//    protected ICar Car;
    protected ICar MyCar;

//    public CarDecorator(ICar car) {
//        Car = car;
//    }
    public CarDecorator(ICar car) {
        MyCar = car;
}

    @Override
    public void Assemble() {
        this.MyCar.Assemble();
    }

    @Override
    public String GetCarName() {
        return this.MyCar.GetCarName();
    }
}
