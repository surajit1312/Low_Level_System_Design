package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.ride.impl;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.ride.IRide;

public class PremiumRide implements IRide {

    @Override
    public void bookRide() {
        System.out.println("Premium ride booked.");
    }

}
