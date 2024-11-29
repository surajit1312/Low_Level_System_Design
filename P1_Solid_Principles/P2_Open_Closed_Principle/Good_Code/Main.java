package P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.impl.AdditionOperation;
import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.impl.SubtractionOperation;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int number1 = 10;
        int number2 = 5;

        AdditionOperation additionOperation = new AdditionOperation();
        int summation = calculator.calculate(number1, number2, additionOperation);

        SubtractionOperation subtractionOperation = new SubtractionOperation();
        int subtraction = calculator.calculate(number1, number2, subtractionOperation);

        System.out.println("Summation   : " + summation);
        System.out.println("Subtraction : " + subtraction);
    }
}
