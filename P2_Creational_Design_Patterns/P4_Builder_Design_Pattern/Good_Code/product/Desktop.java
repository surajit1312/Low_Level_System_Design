package P2_Creational_Design_Patterns.P4_Builder_Design_Pattern.Good_Code.product;

public class Desktop {
    private String brand;
    private String processor;
    private String ram;
    private String storage;
    private boolean hasGPU;
    private boolean hasBluetooth;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setHasGPU(boolean hasGPU) {
        this.hasGPU = hasGPU;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public void showDesktopSpecs() {
        System.out.println("--------------- " + brand + " Desktop ---------------");
        System.out.println("Processor : " + processor);
        System.out.println("RAM : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("GPU : " + hasGPU);
        System.out.println("Bluetooth : " + hasBluetooth);
        System.out.println("-------------------------------------------");
    }
}
