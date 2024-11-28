package P1_Solid_Principles.Open_Closed_Principle.Good_Code.operators.impl;

import P1_Solid_Principles.Open_Closed_Principle.Good_Code.operators.IOperation;

public class AdditionOperation implements IOperation {

    @Override
    public int operate(int number1, int number2) {
        return number1 + number2;
    }

}
