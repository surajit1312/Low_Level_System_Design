package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan;

public interface ISecureLoan extends ILoan {
    public void forecloseLoan();
}
