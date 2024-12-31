package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.impl;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.IPlatform;

public class AndroidPlatform implements IPlatform {

    @Override
    public void processBooking() {
        System.out.println("booked via Android platform");
    }

}
