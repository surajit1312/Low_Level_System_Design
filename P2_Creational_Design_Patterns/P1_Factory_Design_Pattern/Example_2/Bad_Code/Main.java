package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Bad_Code;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Bad_Code.vehicle.IVehicle;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Bad_Code.vehicle.impl.Car;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Bad_Code.vehicle.impl.Truck;

public class Main {
    public static void main(String[] args) {
        IVehicle car = new Car();
        car.drive();

        IVehicle truck = new Truck();
        truck.drive();
    }
}
