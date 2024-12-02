package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.ICab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.constants.CabType;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Good_Code.cab.factory.CabFactory;

public class Main {
    public static void main(String[] args) {
        CabFactory factory = new CabFactory();
        ICab microCab = factory.getCab(CabType.MICRO);
        ICab miniCab = factory.getCab(CabType.MINI);
        ICab luxuryCab = factory.getCab(CabType.LUXURY);
        ICab suvCab = factory.getCab(CabType.SUV);

        microCab.book();
        miniCab.book();
        luxuryCab.book();
        suvCab.book();
    }
}
