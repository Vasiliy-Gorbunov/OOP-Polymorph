import Drivers.B_licence;
import Drivers.C_licence;
import Drivers.D_licence;
import Transport.Bus;
import Transport.Car;
import Transport.Truck;

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
        D_licence max = new D_licence("Max", true, 5);
        maz.getDriver(max);
        C_licence ron = new C_licence("Ron", true, 8);
        daf.getDriver(ron);
        B_licence shon = new B_licence("Shon", true, 10);
        ford.getDriver(shon);
    }
}