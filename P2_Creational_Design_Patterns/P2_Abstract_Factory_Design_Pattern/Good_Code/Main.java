package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory.impl.MacUIFactory;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory.impl.WindowsUIFactory;

public class Main {
    public static void main(String[] args) {
        // Windows UI
        Application winApp = new Application(new WindowsUIFactory());
        winApp.renderUI();

        // Mac UI
        Application macApp = new Application(new MacUIFactory());
        macApp.renderUI();
    }
}
