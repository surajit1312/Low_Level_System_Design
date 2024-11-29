package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan;

public interface ILoan {
    public void doPayment(int amount);

    public void forecloseLoan();

    public void doRepayment(int amount);
}
