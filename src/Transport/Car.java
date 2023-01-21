package Transport;

import Drivers.B_licence;
import Drivers.Driver;

public class Car<A extends B_licence> extends Transport {

    public Car(String brand, String model) {
        super(brand, model);
    }

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println(this.getBrand() + " " + this.getModel() + " завёл мотор");
        System.out.println(this.getBrand() + " " + this.getModel() + " начал движение");
    }

    @Override
    public void endMoving() {
        System.out.println(this.getBrand() + " " + this.getModel() + " затормозил");
        System.out.println(this.getBrand() + " " + this.getModel() + " заглушил двигатель");
    }

    public void getDriver(A driver) {
        System.out.println(driver.getName() + " управляет автомобилем " + this.getBrand() + " " + this.getModel() + " и будет участвовать в заезде");
    }

    @Override
    public void pitStop() {
        System.out.println(this.getBrand() + " " + this.getModel() + " заходит на пит-стоп");
    }

    @Override
    public void getMaxSpeed(int speed) {
        System.out.println(this.getBrand() + " " + this.getModel() + " разогнался до " + speed + " км/ч!");
    }

    @Override
    public void getBestLap(int lapTime) {
        System.out.println("У " + this.getBrand() + " " + this.getModel() + " лучшее время круга: " + lapTime + " сек.");
    }

}
