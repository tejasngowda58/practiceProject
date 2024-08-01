package practice.DesignPatterns.Factory.HeadFirstDP;

import java.util.List;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("Cheese"))
            pizza = new CheesePizza("CheesePizza", "medium", "Tomato", List.of("Cheese"));
        else if (type.equals("Veggie"))
            pizza = new VeggiePizza("VeggiePizza", "medium", "Tomato", List.of("Tomato", "Onions"));

        return pizza;
    }
}
