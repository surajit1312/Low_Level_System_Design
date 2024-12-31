package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.impl;

import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.IOrganizationComponent;

public class Employee implements IOrganizationComponent {
    private String name;
    private String role;
    private double salary;

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Role: " + role + ", Salary: " + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
