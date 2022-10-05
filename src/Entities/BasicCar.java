package Entities;

public class BasicCar extends Car {

    public BasicCar() {}

    public BasicCar(String name, int price) {
        super(name, price);
    }

    @Override
    public int GetCost() {
        return 0;
    }
}
