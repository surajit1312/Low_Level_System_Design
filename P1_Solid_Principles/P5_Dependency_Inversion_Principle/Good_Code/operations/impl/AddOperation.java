package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code.operations.impl;

import P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code.operations.IOperation;

public class AddOperation implements IOperation {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }

}
