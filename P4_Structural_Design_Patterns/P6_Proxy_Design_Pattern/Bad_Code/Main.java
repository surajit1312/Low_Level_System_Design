package P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Bad_Code.image.IImage;
import P4_Structural_Design_Patterns.P6_Proxy_Design_Pattern.Bad_Code.image.impl.RealImage;

public class Main {
    public static void main(String[] args) {
        IImage image1 = new RealImage("image1.jpg");
        IImage image2 = new RealImage("image2.jpg");
        // No way but need to directly call display method
        image1.display();
        image2.display();
    }
}
