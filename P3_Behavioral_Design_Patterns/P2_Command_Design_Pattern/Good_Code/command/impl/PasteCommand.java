package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl;

import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.ICommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.receiver.TextEditor;

public class PasteCommand implements ICommand {

    private TextEditor editor;

    public PasteCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.paste();
    }

    @Override
    public void undo() {
        int clipboardLength = editor.getClipboard().length();
        int start = editor.getText().length() - clipboardLength;
        editor.cut(start, editor.getText().length());
    }

}
