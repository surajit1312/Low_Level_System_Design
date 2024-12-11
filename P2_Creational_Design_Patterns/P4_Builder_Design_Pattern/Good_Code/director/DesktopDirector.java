package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.director;

import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.DesktopBuilder;
import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.product.Desktop;

public class DesktopDirector {

    public Desktop buildDesktop(DesktopBuilder builder) {
        builder
                .buildBrand()
                .buildProcessor()
                .buildRAM()
                .buildStorage()
                .buildGPU()
                .buildBluetooth();
        return builder.getDesktop();
    }
}
