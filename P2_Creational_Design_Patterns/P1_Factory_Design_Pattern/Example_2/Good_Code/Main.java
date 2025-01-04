package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.factory.VehicleFactory;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.IVehicle;

public class Main {
    public static void main(String[] args) {
        IVehicle car = VehicleFactory.createFactory("car");
        car.drive();

        IVehicle truck = VehicleFactory.createFactory("truck");
        truck.drive();
    }
}
