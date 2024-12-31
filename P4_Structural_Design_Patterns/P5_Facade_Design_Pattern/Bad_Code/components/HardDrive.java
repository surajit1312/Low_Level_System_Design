package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Bad_Code.components;

public class HardDrive {
    public byte[] read(long lba, int size) {
        // LBA - Logical Block Accessing
        System.out.println("Reading " + size + " bytes from LBA: " + lba);
        return new byte[size]; // Simulating data read
    }
}
