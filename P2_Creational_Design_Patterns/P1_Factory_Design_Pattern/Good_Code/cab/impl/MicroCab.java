package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.impl;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.ICab;

public class MicroCab implements ICab {
    @Override
    public void book() {
        System.out.println("Micro cab booked!");
    }
}