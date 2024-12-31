package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.concrete;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.IPlatform;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.Ride;

public class EconomyRide extends Ride {

    public EconomyRide(IPlatform platform) {
        super(platform);
    }

    @Override
    public void bookRide() {
        System.out.print("Economy ");
        platform.processBooking();
    }

}
