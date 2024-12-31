package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department.Department;
import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department.Employee;
import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department.Team;

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee("Alice", "Developer", 70000);
        Employee emp2 = new Employee("Bob", "Designer", 65000);
        Employee emp3 = new Employee("Charlie", "Manager", 90000);

        // Create team and add employees
        Team team = new Team("Product Team");
        team.addEmployee(emp1);
        team.addEmployee(emp2);
        team.addEmployee(emp3);

        // Create department and add team
        Department department = new Department("IT Department");
        department.addTeam(team);

        department.showDetails();
        System.out.println("Total Department Salary : " + department.getTotalSalary());
    }
}
