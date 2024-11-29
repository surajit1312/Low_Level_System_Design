package P1_Solid_Principles.P2_Open_Closed_Principle.Bad_Code;

public class Calculator {
    /**
     * This method violates Open Closed Principle as
     * if tomorrow we need to add a new operator like
     * multiplication and division. Also Calculator.java
     * is a tested/deployed code. So if it is modified
     * we need to test it again.
     * 
     * So better is to have a class which can be open for
     * extension whenever a new operation is introduced
     * 
     * @param number1
     * @param number2
     * @param operator
     * @return
     **/
    public int calculate(int number1, int number2, String operator) {
        int result = 0;
        switch (operator) {
            case "sum":
                result = number1 + number2;
                break;
            case "sub":
                result = number1 - number2;
            default:
                break;
        }
        return result;
    }
}
