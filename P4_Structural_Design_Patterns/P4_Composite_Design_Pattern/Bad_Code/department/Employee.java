package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department;

public class Employee {
    private String name;
    private String role;
    private double salary;

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void showDetails() {
        System.out.println("Employee: " + name + ", Role: " + role + ", Salary: " + salary);
    }
}
