package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.IOrganizationComponent;
import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.impl.Employee;
import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.impl.OrganizationGroup;

public class Main {
    public static void main(String[] args) {
        // Create employees
        IOrganizationComponent emp1 = new Employee("Alice", "Developer", 70000);
        IOrganizationComponent emp2 = new Employee("Bob", "Designer", 65000);
        IOrganizationComponent emp3 = new Employee("Charlie", "Manager", 90000);

        // Create a team and add employees
        OrganizationGroup team = new OrganizationGroup("Product Team");
        team.addComponent(emp1);
        team.addComponent(emp2);
        team.addComponent(emp3);

        // Create a department and add the team and manager
        OrganizationGroup department = new OrganizationGroup("IT Department");
        department.addComponent(team);

        department.showDetails();
        System.out.println("Total Department Salary : " + department.getSalary());
    }
}
