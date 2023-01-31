package Drivers;

public abstract class Driver {
    private final String name;
    private boolean licence;
    private int experience;

    public Driver(String name) {
        this(name, false, 0);
    }

    public Driver(String name, boolean licence, int experience) {
        this.name = name;
        this.licence = licence;
        setExperience(experience);
    }

    public String getName() {
        return name;
    }

    public boolean isLicence() {
        return licence;
    }

    public int getExperience() {
        return experience;
    }

    public void setLicence(boolean licence) {
        this.licence = licence;
    }

    public void setExperience(int experience) {
        if (experience > 0) {
            this.experience = experience;
        }
    }

    public void startMoving() {
        System.out.println(this.getName()+ " начал движение");
    }

    public void stopMoving() {
        System.out.println(this.getName()+ " остановился");
    }

    public void refuelCar() {
        System.out.println(this.getName()+ " остановился");
        System.out.println(this.getName()+ " заправил автомобиль");
    }
}

