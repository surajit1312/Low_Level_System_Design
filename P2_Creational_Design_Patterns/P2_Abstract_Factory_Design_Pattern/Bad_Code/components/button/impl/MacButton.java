package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.impl;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.IButton;

public class MacButton implements IButton {
    @Override
    public void render() {
        System.out.println("Mac: Button rendered");
    }
}
