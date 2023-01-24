package Transport;

import Drivers.B_licence;
import Drivers.Driver;

public class Car<A extends B_licence> extends Transport {

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        OFF_ROAD("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String typeName;

        BodyType(String typeName) {
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return "Тип кузова: " + typeName;
        }
    }

    private BodyType bodyType;

    public Car(String brand, String model) {
        super(brand, model);
    }

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
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

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else System.out.println("Тип ТС: "+bodyType.name()+"\n "+getBodyType());
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

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
