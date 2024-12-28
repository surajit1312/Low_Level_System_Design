package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.impl;

import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.ICommand;
import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.receiver.TextEditor;

public class CutCommand implements ICommand {
    private TextEditor editor;
    private String cutText;
    private int start;
    private int end;

    public CutCommand(TextEditor editor, int start, int end) {
        this.editor = editor;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        cutText = editor.getText().substring(start, end);
        editor.cut(start, end);
    }

    @Override
    public void undo() {
        editor.write(cutText);
    }

}
