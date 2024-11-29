package P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.impl;

import P1_Solid_Principles.P3_Liskov_Substitution_Principle.Bad_Code.loan.ILoan;

public class HomeLoan implements ILoan {

    @Override
    public void doPayment(int amount) {
        System.out.println("Payment made towards Home Loan of amount ₹" + amount + ".00");
    }

    @Override
    public void forecloseLoan() {
        System.out.println("Home Loan foreclosed!");
    }

    @Override
    public void doRepayment(int amount) {
        System.out.println("Re-payment made towards Home Loan of amount ₹" + amount + ".00");
    }

}
