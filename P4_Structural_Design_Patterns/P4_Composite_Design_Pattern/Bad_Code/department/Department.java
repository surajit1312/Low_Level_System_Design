package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Bad_Code.department;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Team> teams = new ArrayList<Team>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public double getTotalSalary() {
        double total = 0.0;
        for (Team team : teams) {
            total += team.getTotalSalary();
        }
        return total;
    }

    public void showDetails() {
        System.out.println("Department : " + departmentName);
        for (Team team : teams) {
            team.showDetails();
        }
    }
}
