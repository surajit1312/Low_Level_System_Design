package P1_Solid_Principles.Open_Closed_Principle.Bad_Code;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int number1 = 10;
        int number2 = 5;

        int summation = calculator.calculate(number1, number2, "sum");
        int subtraction = calculator.calculate(number1, number2, "sub");

        System.out.println("Summation   : " + summation);
        System.out.println("Subtraction : " + subtraction);
    }
}
