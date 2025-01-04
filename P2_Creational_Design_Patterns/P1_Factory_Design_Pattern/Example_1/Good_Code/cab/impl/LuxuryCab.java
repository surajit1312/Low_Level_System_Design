package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_1.Good_Code.cab.impl;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Example_1.Good_Code.cab.ICab;

public class LuxuryCab implements ICab {
    @Override
    public void book() {
        System.out.println("Luxury cab booked!");
    }
}
