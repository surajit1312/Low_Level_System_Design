
# Command Design Pattern: Text Editor Example

This example demonstrates the **Command Design Pattern** using a text editor system. The system includes commands for **Cut**, **Copy**, **Paste**, **Undo**, and **Redo** functionality.

---

## Without Applying Command Design Pattern

In the traditional approach, the operations for the text editor are directly implemented in the receiver class (`TextEditor`). This results in tight coupling and lack of support for undo/redo functionality.

### Code
```java
class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void write(String input) {
        text.append(input);
    }

    public void cut(int start, int end) {
        text.delete(start, end);
    }

    public void copy(int start, int end) {
        // Copy logic to clipboard (mock)
        System.out.println("Copied: " + text.substring(start, end));
    }

    public void paste(String clipboardText) {
        text.append(clipboardText);
    }

    public void undo() {
        // Undo logic (mock)
        System.out.println("Undo operation not supported in this example");
    }

    public String getText() {
        return text.toString();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Hello World");
        System.out.println("After Write: " + editor.getText());

        editor.cut(6, 11);
        System.out.println("After Cut: " + editor.getText());

        editor.copy(0, 5);
        editor.paste(" Everyone");
        System.out.println("After Paste: " + editor.getText());
    }
}
```

### Output
```
After Write: Hello World
After Cut: Hello 
Copied: Hello
After Paste: Hello Everyone
```

### Problems:
1. **No Undo/Redo Support**: Undo/Redo is not manageable without custom tracking.
2. **Tightly Coupled Operations**: The operations are directly tied to the editor, making extensibility harder.
3. **Code Duplication**: Repetitive logic for managing states.

---

## With Applying Command Design Pattern

The Command Design Pattern decouples the `TextEditor` (Receiver) from the invoker (`CommandManager`) by encapsulating each action as a command. This enables undo/redo functionality and makes the system extensible.

### Code
```java
// Command Interface
interface Command {
    void execute();
    void undo();
}

// Receiver Class
class TextEditor {
    private StringBuilder text = new StringBuilder();
    private String clipboard = "";

    public void write(String input) {
        text.append(input);
    }

    public void cut(int start, int end) {
        clipboard = text.substring(start, end);
        text.delete(start, end);
    }

    public void copy(int start, int end) {
        clipboard = text.substring(start, end);
    }

    public void paste() {
        text.append(clipboard);
    }

    public String getText() {
        return text.toString();
    }

    public String getClipboard() {
        return clipboard;
    }
}

// Concrete Command Classes
class WriteCommand implements Command {
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

class CutCommand implements Command {
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

class PasteCommand implements Command {
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

// Invoker Class
class CommandManager {
    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoStack.clear();
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redoCommand() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            commandHistory.push(command);
        }
    }
}

// Client Class
public class WithCommandPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();

        Command writeHello = new WriteCommand(editor, "Hello ");
        Command writeWorld = new WriteCommand(editor, "World");
        Command cutCommand = new CutCommand(editor, 6, 11);
        Command pasteCommand = new PasteCommand(editor);

        // Execute commands
        manager.executeCommand(writeHello);
        manager.executeCommand(writeWorld);
        System.out.println("After Writing: " + editor.getText());

        manager.executeCommand(cutCommand);
        System.out.println("After Cutting: " + editor.getText());

        manager.executeCommand(pasteCommand);
        System.out.println("After Pasting: " + editor.getText());

        // Undo operations
        manager.undoCommand();
        System.out.println("After Undo: " + editor.getText());

        // Redo operations
        manager.redoCommand();
        System.out.println("After Redo: " + editor.getText());
    }
}
```

### Output
```
After Writing: Hello World
After Cutting: Hello 
After Pasting: Hello Hello
After Undo: Hello 
After Redo: Hello Hello
```

---

### Advantages of Using the Command Design Pattern
1. **Decoupling**: The `CommandManager` (Invoker) is decoupled from the logic of `TextEditor` (Receiver).
2. **Undo/Redo Support**: Each command maintains its undo behavior.
3. **Extensibility**: Adding new commands (e.g., `DeleteCommand`) doesn't require changing existing classes.

This implementation is ideal for systems requiring flexible management of user commands.
