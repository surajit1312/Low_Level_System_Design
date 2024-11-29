package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan;

/**
 * This is loan closure service which is responsible
 * to close the loan before its actual due date.
 * 
 * Credit card loan is not supporting foreclosure
 * so it will throw exception which is wrong in design where
 * we are unable to substitue subtype with super type.
 * 
 * That is violation of Liksov Substitution Principle.
 * 
 * Solution to this lets segregate the method in different super types
 * and make supertype substituable at any given time.
 */
public class LoanClosureService {
    private ISecureLoan loan;

    public LoanClosureService(ISecureLoan loan) {
        this.loan = loan;
    }

    public void forecloseLoan() {
        loan.forecloseLoan();
    }
}
