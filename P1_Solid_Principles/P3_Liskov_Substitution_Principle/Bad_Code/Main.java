package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code;

import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.ILoan;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.LoanClosureService;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.impl.CreditCardLoan;
import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.impl.HomeLoan;

public class Main {
    private static LoanClosureService service = null;

    public static void main(String[] args) {
        ILoan homeLoan = new HomeLoan();
        homeLoan.doPayment(10000);
        homeLoan.doRepayment(5000);
        service = new LoanClosureService(homeLoan);
        service.forecloseLoan();

        System.out.println();

        ILoan creditCardLoan = new CreditCardLoan();
        creditCardLoan.doPayment(10000);
        creditCardLoan.doRepayment(5000);
        service = new LoanClosureService(creditCardLoan);
        service.forecloseLoan();
    }
}
