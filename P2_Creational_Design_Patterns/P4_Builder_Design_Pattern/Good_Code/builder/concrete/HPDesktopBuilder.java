package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.concrete;

import P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.builder.DesktopBuilder;

public class HPDesktopBuilder extends DesktopBuilder {
    @Override
    public DesktopBuilder buildBrand() {
        desktop.setBrand("HP");
        return this;
    }

    @Override
    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("Intel i9 Octa Core 4.4Ghz");
        return this;
    }

    @Override
    public DesktopBuilder buildRAM() {
        desktop.setRam("Corsair 32Gb DDR5 RAM 4800 Mhz");
        return this;
    }

    @Override
    public DesktopBuilder buildStorage() {
        desktop.setStorage("2Tb Samsung SSD");
        return this;
    }

    @Override
    public DesktopBuilder buildGPU() {
        desktop.setHasGPU(true);
        return this;
    }

    @Override
    public DesktopBuilder buildBluetooth() {
        desktop.setHasBluetooth(false);
        return this;
    }
}
