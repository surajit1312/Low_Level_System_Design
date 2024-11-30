package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.IOperation;

public class Calculator {
    public int calculate(int a, int b, IOperation operation) {
        return operation.operate(a, b);
    }
}
