package Entities;

import Interfaces.ICar;

public abstract class Car extends Item implements ICar {
    public String Model;
    public String CarType;

    public Car() {}

    public Car(String name, int price) {
        super(name, price);
    }

    public Car(Car car) {
        super(car.Name, car.Price);
    }

    public void SetCarModel(String model) {
        Model = model;
    }

    public String GetCarModel() {
        return Model;
    }

    public void SetCarType(String type) {
        CarType = type;
    }

    public String GetCarType() {
        return CarType;
    }

    @Override
    public void Assemble() {
        System.out.println("Basic car");
    }

    @Override
    public String GetCarName() {
//        return this.Name;
        return GetName();
    }

    public String getVoucher() {
        return "Car";
    }

    public int getPrice() {
        return Price;
    }
}
