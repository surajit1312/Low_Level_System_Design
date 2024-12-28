package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.invoker;

import java.util.Stack;

import P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.command.ICommand;

public class Invoker {
    private Stack<ICommand> historyStack = new Stack<ICommand>();
    private Stack<ICommand> redoStack = new Stack<ICommand>();

    public void executeCommand(ICommand command) {
        command.execute();
        historyStack.push(command);
        redoStack.clear();
    }

    public void undoCommand() {
        if (!historyStack.isEmpty()) {
            ICommand command = historyStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redoCommand() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.execute();
            historyStack.push(command);
        }
    }
}
