package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Bad_Code;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void write(String input) {
        text.append(input);
    }

    public void cut(int start, int end) {
        text.delete(start, end);
    }

    public void copy(int start, int end) {
        System.out.println("Copied text : " + text.substring(start, end));
    }

    public void paste(String clipboardText) {
        text.append(clipboardText);
    }

    public void undo() {
        System.out.println("Undo operation is not supported");
    }

    public String getText() {
        return text.toString();
    }
}
