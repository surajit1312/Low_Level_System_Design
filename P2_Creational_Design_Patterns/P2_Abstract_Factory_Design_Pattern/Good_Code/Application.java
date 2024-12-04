package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.textbox.ITextBox;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.components.button.IButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Good_Code.factory.IUIFactory;

public class Application {

    private IButton button;
    private ITextBox textBox;

    public Application(IUIFactory factory) {
        button = factory.createButton();
        textBox = factory.createTextBox();
    }

    public void renderUI() {
        button.render();
        textBox.render();
    }

}
