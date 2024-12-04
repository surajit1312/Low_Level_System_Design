package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.button.IButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.textbox.ITextBox;

public interface IUIFactory {
    public IButton createButton();

    public ITextBox createTextBox();
}
