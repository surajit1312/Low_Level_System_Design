package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.Example_1.cab.impl;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.Example_1.cab.ICab;

public class LuxuryCab implements ICab {
    @Override
    public void book() {
        System.out.println("Luxury cab booked!");
    }
}
