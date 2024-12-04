package P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code;

import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.IButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.impl.MacButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.button.impl.WindowsButton;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.textbox.ITextBox;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.textbox.impl.MacTextBox;
import P2_Creational_Design_Patterns.P2_Abstract_Factory_Design_Pattern.Bad_Code.components.textbox.impl.WindowsTextBox;

public class Main {
    public static void main(String[] args) {
        // Windows UI
        IButton winButton = new WindowsButton();
        ITextBox winTextBox = new WindowsTextBox();
        winButton.render();
        winTextBox.render();

        // Mac UI
        IButton macButton = new MacButton();
        ITextBox macTextBox = new MacTextBox();
        macButton.render();
        macTextBox.render();
    }
}
