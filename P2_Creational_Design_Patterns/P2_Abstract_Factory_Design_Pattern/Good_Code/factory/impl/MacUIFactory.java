package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory.impl;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.button.IButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.button.impl.MacButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.textbox.ITextBox;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.textbox.impl.MacTextBox;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory.IUIFactory;

public class MacUIFactory implements IUIFactory {
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}
