package P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Bad_Code;

import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Bad_Code.cab.ICab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Bad_Code.cab.impl.LuxuryCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Bad_Code.cab.impl.MicroCab;
import P2_Creational_Design_Patterns.P1_Factory_Design_Pattern.Bad_Code.cab.impl.MiniCab;

public class Main {
    public static void main(String[] args) {
        ICab microCab = new MicroCab();
        ICab miniCab = new MiniCab();
        ICab luxuryCab = new LuxuryCab();
        microCab.book();
        miniCab.book();
        luxuryCab.book();
    }
}
