package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder;

import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.product.Desktop;

public abstract class DesktopBuilder {
    protected Desktop desktop = new Desktop();

    public abstract DesktopBuilder buildBrand();

    public abstract DesktopBuilder buildProcessor();

    public abstract DesktopBuilder buildRAM();

    public abstract DesktopBuilder buildStorage();

    public abstract DesktopBuilder buildGPU();

    public abstract DesktopBuilder buildBluetooth();

    public Desktop getDesktop() {
        return desktop;
    }
}
