package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components;

public class CPU {
    public void freeze() {
        System.out.println("CPU freezing.");
    }

    public void jump(long position) {
        System.out.println("CPU jumping to position: " + position);
    }

    public void execute() {
        System.out.println("CPU executing...");
    }
}
