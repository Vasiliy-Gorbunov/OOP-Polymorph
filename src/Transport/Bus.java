package Transport;

import Drivers.CheckLicenceException;
import Drivers.LicenceD;
import Drivers.Driver;

public class Bus<A extends LicenceD> extends Transport {

    public enum BodyType {
        EXTRA_SMALL(null, 10),
        SMALL(null, 25),
        MEDIUM(40, 50),
        HIGH(60, 80),
        EXTRA_HIGH(100, 120);

        private final Integer lowerCapacity;
        private final Integer higherCapacity;

        BodyType(Integer lowerCapacity, Integer higherCapacity) {
            this.lowerCapacity = lowerCapacity;
            this.higherCapacity = higherCapacity;
        }

        @Override
        public String toString() {
            if (lowerCapacity == null) {
                return "Вместимость до " + higherCapacity + " человек";
            } else if (higherCapacity == null) {
                return "Вместимость от " + lowerCapacity + " человек";
            } else {
                return "Вместимость от " + lowerCapacity + " до " + higherCapacity + " человек";
            }
        }
    }

    private BodyType bodyType;

    public Bus(String brand, String model) {
        super(brand, model);
    }

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Bus(String brand, String model, double engineVolume, BodyType bodyType) {
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
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else System.out.println("Тип ТС: " + bodyType.name() + "\n " + getBodyType());
    }

    @Override
    public void passDiagnostics(Driver driver) {
        throw new RuntimeException("Автобусам диагностика не проводится");
    }

    public void getDriver(A driver) throws CheckLicenceException {
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
