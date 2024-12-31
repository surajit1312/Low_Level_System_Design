package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.concrete;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.IPlatform;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.Ride;

public class PremiumRide extends Ride {

    public PremiumRide(IPlatform platform) {
        super(platform);
    }

    @Override
    public void bookRide() {
        System.out.print("Premium ");
        platform.processBooking();
    }

}
