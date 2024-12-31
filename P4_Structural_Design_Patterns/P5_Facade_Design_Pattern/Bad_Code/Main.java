package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components.CPU;
import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components.HardDrive;
import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components.Memory;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        // Booting up the computer
        System.out.println("Booting up the computer...");
        cpu.freeze();
        byte[] bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        cpu.jump(0);
        cpu.execute();
    }
}
