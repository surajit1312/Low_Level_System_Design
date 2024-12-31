package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.platform.AndroidEconomyRide;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.platform.IOSPremiumRide;
import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Bad_Code.ride.IRide;

public class Main {
    public static void main(String[] args) {
        IRide economyRide = new AndroidEconomyRide();
        economyRide.bookRide();

        IRide premiumRide = new IOSPremiumRide();
        premiumRide.bookRide();
    }
}
