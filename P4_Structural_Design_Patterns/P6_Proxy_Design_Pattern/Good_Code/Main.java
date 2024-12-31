package P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.IImage;
import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Good_Code.image.impl.ProxyImage;

public class Main {
    public static void main(String[] args) {
        IImage image1 = new ProxyImage("image1.jpg");
        IImage image2 = new ProxyImage("image2.jpg");
        // We secure the RealImage via Proxy Layer i.e. ProxyImage Class instances
        // the below calls loads the real images when needed i.e. it lazy loads it
        image1.display();
        image2.display();
    }
}
