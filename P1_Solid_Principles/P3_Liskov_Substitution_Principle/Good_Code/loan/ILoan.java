package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Good_Code.loan;

public interface ILoan {
    public void doPayment(int amount);

    public void doRepayment(int amount);
}
