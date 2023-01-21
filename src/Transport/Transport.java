package Transport;

public abstract class Transport {

    private final String brand;
    private final String model;
    private double engineVolume;

    public Transport(String brand, String model) {
        this(brand, model, 1.5);
    }

    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            brand = "default";
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            model = "default";
        }
        this.brand = brand;
        this.model = model;
        setEngineVolume(engineVolume);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (Double.compare(engineVolume, 0) == 0 || engineVolume < 0) {
            engineVolume = 1.5;
        }
        this.engineVolume = engineVolume;
    }

    public abstract void startMoving();

    public abstract void endMoving();

    private String separator() {
        return "=======================";
    }

    @Override
    public String toString() {
        String type = "легковой";
        if (this.getClass() == Truck.class) {
            type = "грузовой";
        } else if (this.getClass() == Bus.class) {
            type = "автобус";
        }
        return "Тип авто: " + type + "\n " +
                "Марка: " + brand + "\n " +
                "Модель: " + model + "\n " +
                "Объём двигателя: " + engineVolume + "\n" + separator();
    }
}
