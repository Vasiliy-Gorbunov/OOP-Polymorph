package Transport;

public class Mechanic {
    private String name;
    private String company;

    public Mechanic(String name) {
        this(name, "default");
    }

    public Mechanic(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public void performMaintenance(Transport transport) {
        System.out.println("Механик " + this.getName() + " начал техобслуживание " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Механик " + this.getName() + " закончил техобслуживание " + transport.getBrand() + " " + transport.getModel());
    }

    public void repairCar(Transport transport) {
        System.out.println("Механик " + this.getName() + " начал ремонт " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Механик " + this.getName() + " закончил ремонт " + transport.getBrand() + " " + transport.getModel());
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Механик: "+name+" Компания: "+company+".";
    }
}
