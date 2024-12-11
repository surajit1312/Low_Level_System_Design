package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.concrete;

import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.DesktopBuilder;

public class DellDesktopBuilder extends DesktopBuilder {
    @Override
    public DesktopBuilder buildBrand() {
        desktop.setBrand("DELL");
        return this;
    }

    @Override
    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("AMD Ryzen 7 5800H 4.5Ghz");
        return this;
    }

    @Override
    public DesktopBuilder buildRAM() {
        desktop.setRam("Gigabyte 48Gb DDR4 RAM 3200 Mhz");
        return this;
    }

    @Override
    public DesktopBuilder buildStorage() {
        desktop.setStorage("4Tb Western Digital SSD");
        return this;
    }

    @Override
    public DesktopBuilder buildGPU() {
        desktop.setHasGPU(true);
        return this;
    }

    @Override
    public DesktopBuilder buildBluetooth() {
        desktop.setHasBluetooth(true);
        return this;
    }
}
