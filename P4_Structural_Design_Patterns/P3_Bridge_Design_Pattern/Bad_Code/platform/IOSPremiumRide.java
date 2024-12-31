package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.platform;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.ride.impl.PremiumRide;

public class IOSPremiumRide extends PremiumRide {
    @Override
    public void bookRide() {
        System.out.println("Premium ride booked via iOS.");
    }
}
