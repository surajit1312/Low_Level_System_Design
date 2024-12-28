package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl;

import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.ICommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.receiver.TextEditor;

public class WriteCommand implements ICommand {

    private TextEditor editor;
    private String text;

    public WriteCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.write(text);
    }

    @Override
    public void undo() {
        int length = text.length();
        int start = editor.getText().length() - length;
        editor.cut(start, editor.getText().length());
    }

}
