package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.impl;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.IButton;

public class WindowsButton implements IButton {
    @Override
    public void render() {
        System.out.println("Windows: Button rendered");
    }
}
