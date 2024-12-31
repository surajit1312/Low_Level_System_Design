package P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.impl;

import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.IImage;

public class ProxyImage implements IImage {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
