package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.textbox.impl;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.textbox.ITextBox;

public class WindowsTextBox implements ITextBox {
    @Override
    public void render() {
        System.out.println("Windows: TextBox rendered");
    }
}
