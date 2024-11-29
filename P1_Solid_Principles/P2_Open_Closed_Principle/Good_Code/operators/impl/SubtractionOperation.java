package P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.impl;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.IOperation;

public class SubtractionOperation implements IOperation {

    @Override
    public int operate(int number1, int number2) {
        return Math.abs(number1 - number2);
    }

}
