package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.impl;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_2.Good_Code.vehicle.IVehicle;

public class Truck implements IVehicle {

    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }

}
