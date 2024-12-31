package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Employee> employees = new ArrayList<Employee>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double getTotalSalary() {
        double total = 0.0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    public void showDetails() {
        System.out.println("Team : " + teamName);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}
