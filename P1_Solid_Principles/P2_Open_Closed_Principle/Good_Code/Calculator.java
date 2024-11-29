package P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code;

import P1_Solid_Principles.P2_Open_Closed_Principle.Good_Code.operators.IOperation;

public class Calculator {
    /**
     * @param number1
     * @param number2
     * @param operator
     * @return
     **/
    public int calculate(int number1, int number2, IOperation operator) {
        return operator.operate(number1, number2);
    }
}
