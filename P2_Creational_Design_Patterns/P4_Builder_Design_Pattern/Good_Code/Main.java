package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.DesktopBuilder;
import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.concrete.DellDesktopBuilder;
import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.concrete.HPDesktopBuilder;
import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.director.DesktopDirector;
import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.product.Desktop;

public class Main {
    public static void main(String[] args) {
        DesktopBuilder hpDesktopBuilder = new HPDesktopBuilder();
        DesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();

        DesktopDirector hpDesktopDirector = new DesktopDirector();
        DesktopDirector dellDesktopDirector = new DesktopDirector();

        Desktop hpDesktop = hpDesktopDirector.buildDesktop(hpDesktopBuilder);
        Desktop dellDesktop = dellDesktopDirector.buildDesktop(dellDesktopBuilder);

        hpDesktop.showDesktopSpecs();
        dellDesktop.showDesktopSpecs();
    }
}
