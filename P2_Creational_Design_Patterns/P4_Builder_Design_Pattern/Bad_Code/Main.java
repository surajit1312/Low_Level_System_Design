package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        Desktop hpDesktop = new Desktop();
        hpDesktop.setBrand("HP");
        hpDesktop.setProcessor("Intel i9 Octa Core 4.4Ghz");
        hpDesktop.setRam("Corsair 32Gb DDR5 RAM 4800 Mhz");
        hpDesktop.setStorage("2Tb Samsung SSD");
        hpDesktop.setHasGPU(true);
        hpDesktop.setHasBluetooth(false);

        Desktop dellDesktop = new Desktop();
        dellDesktop.setBrand("DELL");
        dellDesktop.setProcessor("AMD Ryzen 7 5800H 4.5Ghz");
        dellDesktop.setRam("Gigabyte 48Gb DDR4 RAM 3200 Mhz");
        dellDesktop.setStorage("4Tb Western Digital SSD");
        dellDesktop.setHasGPU(true);
        dellDesktop.setHasBluetooth(true);

        hpDesktop.showDesktopSpecs();
        dellDesktop.showDesktopSpecs();
    }
}
