package P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P5_Facade_Design_Pattern.Good_Code.facade.ComputerFacade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade facade = new ComputerFacade();
        facade.start();
    }
}
