package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Good_Code.operations.impl;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.IOperation;

public class SubtractOperation implements IOperation {

    @Override
    public int operate(int a, int b) {
        return a - b;
    }

}
