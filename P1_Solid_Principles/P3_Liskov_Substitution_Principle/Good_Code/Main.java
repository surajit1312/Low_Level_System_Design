package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code;

import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan.ILoan;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan.ISecureLoan;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan.LoanClosureService;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan.impl.CreditCardLoan;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan.impl.HomeLoan;

public class Main {
    private static LoanClosureService service = null;

    public static void main(String[] args) {
        ISecureLoan homeLoan = new HomeLoan();
        homeLoan.doPayment(10000);
        homeLoan.doRepayment(5000);
        service = new LoanClosureService(homeLoan);
        service.forecloseLoan();

        System.out.println();

        ILoan creditCardLoan = new CreditCardLoan();
        creditCardLoan.doPayment(10000);
        creditCardLoan.doRepayment(5000);
    }
}
