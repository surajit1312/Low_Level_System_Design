package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Bad_Code;

import P1_Solid_Principles.P5_Dependency_Inversion_Principle.Bad_Code.operations.AddOperation;
import P1_Solid_Principles.P5_Dependency_Inversion_Principle.Bad_Code.operations.SubtractOperation;

public class Calculator {
    public int calculate(int a, int b, String operator) {
        int result = 0;
        switch (operator) {
            case "add":
                AddOperation addOperation = new AddOperation();
                result = addOperation.add(a, b);
                break;
            case "subtract":
                SubtractOperation subOperation = new SubtractOperation();
                result = subOperation.subtract(a, b);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
