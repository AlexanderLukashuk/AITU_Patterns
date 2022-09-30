package Entities;

import Decorator.CarDecorator;
import Interfaces.ICar;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(ICar car) {
        super(car);
    }

    @Override
    public void Assemble() {
        super.Assemble();
        System.out.println(" Adding features of Luxury Car ");
    }
}
