package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.factory;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.ICab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.impl.LuxuryCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.impl.MicroCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.impl.MiniCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.impl.SUVCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.constants.CabType;

public class CabFactory {
    public ICab getCab(CabType type) {
        if (type == CabType.MICRO) {
            return new MicroCab();
        } else if (type == CabType.MINI) {
            return new MiniCab();
        } else if (type == CabType.LUXURY) {
            return new LuxuryCab();
        } else if (type == CabType.SUV) {
            return new SUVCab();
        } else {
            throw new IllegalArgumentException("Invalid cab type " + type + " passes in the argument");
        }
    }
}
