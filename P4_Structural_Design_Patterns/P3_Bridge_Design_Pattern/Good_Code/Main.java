package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.impl.AndroidPlatform;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.impl.IOSPlatform;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.Ride;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.concrete.EconomyRide;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride.concrete.PremiumRide;

public class Main {
    public static void main(String[] args) {
        // Economy Ride booking
        Ride economyRide = new EconomyRide(new AndroidPlatform());
        economyRide.bookRide();

        // Premium Ride booking
        Ride premiumRide = new PremiumRide(new IOSPlatform());
        premiumRide.bookRide();
    }
}
