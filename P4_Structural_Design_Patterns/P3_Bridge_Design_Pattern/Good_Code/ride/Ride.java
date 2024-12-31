package P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.ride;

import P4_Structural_Design_Patterns.P3_Bridge_Design_Pattern.Good_Code.platform.IPlatform;

public abstract class Ride {
    protected IPlatform platform;

    public Ride(IPlatform platform) {
        this.platform = platform;
    }

    public abstract void bookRide();
}
