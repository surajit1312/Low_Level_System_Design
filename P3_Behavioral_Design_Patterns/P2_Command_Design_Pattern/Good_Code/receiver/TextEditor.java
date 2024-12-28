package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Good_Code.receiver;

public class TextEditor {
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
