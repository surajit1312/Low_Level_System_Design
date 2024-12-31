package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Loading data into memory at position: " + position);
    }
}
