package Transport;

import Drivers.CheckLicenceException;
import Drivers.Driver;

import java.util.*;

public abstract class Transport implements Competitive {

    private static Map<Transport, Set<Mechanic>> mechanics = new HashMap<>();

    private Set<Driver> drivers = new HashSet<>();

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

    public abstract void printType();

    public abstract void passDiagnostics(Driver driver) throws CheckLicenceException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    public void addMechanic(Mechanic mechanic) {
        Set<Mechanic> mechanicSet = mechanics.getOrDefault(this, new HashSet<>());
        mechanicSet.add(mechanic);
        mechanics.put(this, mechanicSet);
    }
    public static String getMechanics() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Transport, Set<Mechanic>> entry : mechanics.entrySet()) {
            builder.append(entry.getKey().getBrand()).append(" ").append(entry.getKey().getModel()).append(" --> ");
            for (Mechanic mechanic : entry.getValue()) {
                builder.append(mechanic.getName()).append(", ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
}
