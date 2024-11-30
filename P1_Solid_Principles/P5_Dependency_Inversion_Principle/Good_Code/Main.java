package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.impl.AdditionOperation;
import P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code.operations.impl.SubtractOperation;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultAdd = calculator.calculate(1000, 100, new AdditionOperation());
        System.out.println(resultAdd);

        int resultSub = calculator.calculate(1000, 100, new SubtractOperation());
        System.out.println(resultSub);
    }
}
