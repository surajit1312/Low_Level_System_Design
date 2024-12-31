package P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.impl;

import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.IImage;

public class RealImage implements IImage {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + fileName);
    }
}
