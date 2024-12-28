package P3_Behavioral_Design_Patterns.P2_Command_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.write("Hello World");
        System.out.println("Text after Write operation is : " + editor.getText());
        editor.cut(6, 11);
        System.out.println("Text after Cut text operation is : " + editor.getText());
        editor.copy(0, 5);
        editor.paste("Everyone");
        System.out.println("Text after Paste operation is : " + editor.getText());
    }
}
