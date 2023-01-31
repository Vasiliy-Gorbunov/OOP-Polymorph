import Drivers.*;
import Transport.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("BMW", "Z8", 4.9);
        Car mercedes = new Car("Mercedes", "AMG One", 1.6);
        Car ford = new Car("Ford", "GT40", 4.7);
        Car aston = new Car("Aston Martin", "DB9", 6.0);
        Truck daf = new Truck("DAF", "XF", 10.8);
        Truck volvo = new Truck("Volvo", "FH", 12.8);
        Truck scania = new Truck("Scania", "XT", 16.4);
        Truck kamaz = new Truck("KamAZ", "5320", 10.85);
        Bus maz = new Bus("МАЗ", "203047", 7.4);
        Bus nefaz = new Bus("НЕФАЗ", "5299", 7.5);
        Bus higer = new Bus("HIGER", "KLQ6128LQ");
        Bus kingLong = new Bus("KING LONG", "XMQ6129Y");
//        System.out.println(bmw);
//        System.out.println(daf);
//        System.out.println(maz);
//        mercedes.startMoving();
//        volvo.endMoving();
//        nefaz.startMoving();
//        bmw.pitStop();
//        volvo.getMaxSpeed(150);
//        higer.getBestLap(248);
//        maz.getDriver(max);
//        daf.passDiagnostics(ron);
//        ford.passDiagnostics(shon);
//        maz.setBodyType(Bus.BodyType.MEDIUM);
//        nefaz.setBodyType(Bus.BodyType.HIGH);
//        maz.printType();
//        nefaz.printType();
//        higer.printType();
//        bmw.setBodyType(Car.BodyType.COUPE);
//        mercedes.setBodyType(Car.BodyType.SEDAN);
//        bmw.printType();
//        mercedes.printType();
//        ford.printType();
//        daf.setBodyType(Truck.BodyType.N1);
//        volvo.setBodyType(Truck.BodyType.N2);
//        scania.setBodyType(Truck.BodyType.N3);
//        daf.printType();
//        volvo.printType();
//        scania.printType();
//        kamaz.printType();
        List<Transport> transports = new LinkedList<>();
        transports.add(bmw);
        transports.add(mercedes);
        transports.add(ford);
        transports.add(aston);
        transports.add(daf);
        transports.add(volvo);
        transports.add(scania);
        transports.add(kamaz);
        transports.add(maz);
        transports.add(nefaz);
        transports.add(higer);
        transports.add(kingLong);

        LicenceB shon = new LicenceB("Shon", true, 10);
        LicenceC ron = new LicenceC("Ron", true, 8);
        LicenceD max = new LicenceD("Max", true, 5);

        ford.addDriver(shon);
        ford.addDriver(shon);
        ford.addDriver(shon);
        ford.addDriver(ron);
        ford.addDriver(ron);
        ford.addDriver(max);
        System.out.println(ford.getDrivers());

//        Mechanic alex = new Mechanic ("Alex", "PitMoto");
//        Mechanic bob = new Mechanic("Bob", "Ferrari");
//        Mechanic clark = new Mechanic("Clark", "Donnako");
//        Mechanic donny = new Mechanic("Donny", "RepairCo");
//        Mechanic john = new Mechanic("John", "FixIt");

//        ford.addMechanic(bob);
//        ford.addMechanic(alex);
//        ford.addMechanic(clark);
//        aston.addMechanic(bob);
//        System.out.println(ford.getMechanics());

//        ServiceStation.addToQueue(ford);
//        ServiceStation.addToQueue(aston);
//        ServiceStation.addToQueue(kamaz);
//        ServiceStation.addToQueue(daf);
//        ServiceStation.addToQueue(scania);
//        ServiceStation.addToQueue(maz);
//        ServiceStation.conductService();

//        alex.performMaintenance(daf);
//        bob.repairCar(ford);
    }
}