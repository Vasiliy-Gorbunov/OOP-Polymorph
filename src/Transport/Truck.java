package Transport;

import Drivers.LicenceC;
import Drivers.CheckLicenceException;
import Drivers.Driver;

public class Truck<A extends LicenceC> extends Transport {

    public enum BodyType {
        N1(null, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);

        private final Float lowerLimit;
        private final Float upperLimit;

        BodyType(Float lowerLimit, Float upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public String toString() {
            if (lowerLimit == null) {
                return "Грузоподъёмность до " + upperLimit + " тонн";
            } else if (upperLimit == null) {
                return "Грузоподъёмность от " + lowerLimit + " тонн";
            } else {
                return "Грузоподъёмность от " + lowerLimit + " до " + upperLimit + " тонн";
            }
        }
    }

    private BodyType bodyType;

    public Truck(String brand, String model) {
        super(brand, model);
    }

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Truck(String brand, String model, double engineVolume, BodyType bodyType) {
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
