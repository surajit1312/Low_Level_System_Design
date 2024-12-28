package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.ICommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl.CutCommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl.PasteCommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl.WriteCommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.invoker.Invoker;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.receiver.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Invoker invoker = new Invoker();

        ICommand writeHello = new WriteCommand(editor, "Hello ");
        ICommand writeWorld = new WriteCommand(editor, "World");
        ICommand cutCommand = new CutCommand(editor, 6, 11);
        ICommand pasteCommand = new PasteCommand(editor);

        invoker.executeCommand(writeHello);
        invoker.executeCommand(writeWorld);
        System.out.println("After Write Operation : " + editor.getText());

        invoker.executeCommand(cutCommand);
        System.out.println("After Cut Operation : " + editor.getText());

        invoker.executeCommand(pasteCommand);
        System.out.println("After Paste Operation : " + editor.getText());

        invoker.undoCommand();
        System.out.println("After Undo Operation : " + editor.getText());

        invoker.redoCommand();
        System.out.println("After Redo Operation : " + editor.getText());
    }
}
