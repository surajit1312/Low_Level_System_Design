package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.impl;

import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.ILoan;

public class CreditCardLoan implements ILoan {

    @Override
    public void doPayment(int amount) {
        System.out.println("Payment made towards Credit Card Expense of amount ₹" + amount + ".00");
    }

    @Override
    public void forecloseLoan() {
        System.out.println("Foreclosing is not allowed for Credit Card Loan!!!");
    }

    @Override
    public void doRepayment(int amount) {
        System.out.println("Re-payment made towards Credit Card Expense of amount ₹" + amount + ".00");
    }

}
