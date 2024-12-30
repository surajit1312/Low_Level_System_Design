package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.Pizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.concrete.FarmhousePizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.concrete.MargheritaPizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.concrete.CheeseToppings;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.concrete.MushroomToppings;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.concrete.OliveToppings;

public class Main {
    public static void main(String[] args) {
        // Create a Margherita Pizza
        Pizza margherita = new MargheritaPizza();
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        // Add Cheese toppings to Margherita Pizza
        margherita = new CheeseToppings(margherita);
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        // Add Olive toppings to Margherita and Cheese Pizza
        margherita = new OliveToppings(margherita);
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        Pizza farmhouse = new FarmhousePizza();
        System.out.println(farmhouse.getDescription() + " - Cost: $" + farmhouse.getCost());

        // Add Cheese toppings to Farmhouse Pizza
        farmhouse = new CheeseToppings(farmhouse);
        System.out.println(farmhouse.getDescription() + " - Cost: $" + farmhouse.getCost());

        // Add Mushroom toppings to Farmhouse and Cheese Pizza
        farmhouse = new MushroomToppings(farmhouse);
        System.out.println(farmhouse.getDescription() + " - Cost: $" + farmhouse.getCost());
    }
}
