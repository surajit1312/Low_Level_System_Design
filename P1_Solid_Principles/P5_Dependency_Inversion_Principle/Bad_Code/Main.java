package P1_Solid_Principles.P5_Dependency_Inversion_Principle.Bad_Code;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultAdd = calculator.calculate(1000, 100, "add");
        System.out.println(resultAdd);

        int resultSub = calculator.calculate(1000, 100, "subtract");
        System.out.println(resultSub);
    }
}
