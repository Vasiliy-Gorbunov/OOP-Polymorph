package Transport;

import Drivers.LicenceB;
import Drivers.CheckLicenceException;
import Drivers.Driver;

public class Car<A extends LicenceB> extends Transport {

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
        } else {
            System.out.println("Тип ТС: " + bodyType.name() + "\n " + getBodyType());
        }
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

    @Override
    public void passDiagnostics(Driver driver) throws CheckLicenceException {
        try {
            getDriver((A) driver);
        } catch (ClassCastException e) {
            throw new CheckLicenceException("У водителя неподходящая категория прав!");
        }
    }

    private void getDriver(A driver) throws CheckLicenceException {
        if (driver.isLicence()) {
            System.out.println(driver.getName() + " управляет автомобилем " + this.getBrand() + " " + this.getModel() + " и будет участвовать в заезде");
        } else {
            throw new CheckLicenceException("У водителя нет прав!");
        }
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
