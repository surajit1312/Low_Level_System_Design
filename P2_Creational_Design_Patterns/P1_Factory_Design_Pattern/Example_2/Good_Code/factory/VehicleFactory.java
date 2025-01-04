package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.factory;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.IVehicle;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.impl.Car;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.impl.Truck;

public class VehicleFactory {
    public static IVehicle createFactory(String vehicleType) {
        IVehicle vehicle = null;
        switch (vehicleType) {
            case "car":
                vehicle = new Car();
                break;
            case "truck":
                vehicle = new Truck();
                break;
            default:
                throw new IllegalArgumentException("Vehicle Type is unknown");
        }
        return vehicle;
    }
}
