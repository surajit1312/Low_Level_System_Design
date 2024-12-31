package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code.facade;

import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code.components.CPU;
import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code.components.HardDrive;
import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code.components.Memory;

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        // Booting up the computer
        System.out.println("Booting up the computer...");
        cpu.freeze();
        byte[] bootSector = hardDrive.read(0, 1024);
        memory.load(0, bootSector);
        cpu.jump(0);
        cpu.execute();
    }
}
