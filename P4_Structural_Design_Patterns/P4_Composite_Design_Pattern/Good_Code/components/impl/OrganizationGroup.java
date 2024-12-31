package P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.impl;

import java.util.ArrayList;
import java.util.List;

import P4_Structural_Design_Patterns.P4_Composite_Design_Pattern.Good_Code.components.IOrganizationComponent;

public class OrganizationGroup implements IOrganizationComponent {
    private String componentName;
    private List<IOrganizationComponent> components = new ArrayList<IOrganizationComponent>();

    public OrganizationGroup(String componentName) {
        this.componentName = componentName;
    }

    public void addComponent(IOrganizationComponent childComponent) {
        components.add(childComponent);
    }

    public void removeComponent(IOrganizationComponent childComponent) {
        components.remove(childComponent);
    }

    @Override
    public void showDetails() {
        System.out.println("Component Name : " + componentName);
        for (IOrganizationComponent child : components) {
            child.showDetails();
        }
    }

    @Override
    public double getSalary() {
        double total = 0.0;
        System.out.println("Component Total for : " + componentName);
        for (IOrganizationComponent child : components) {
            total += child.getSalary();
        }
        return total;
    }
}
