package practice.DesignPatterns.Factory.HeadFirstDP;

import java.util.List;

public class NYPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        SimplePizzaFactory pizzaFactory;
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza("NYStyleCheesePizza", "medium", "Tomato", List.of("Tomato", "Onions"));
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza("NYStyleVeggiePizza", "medium", "Tomato", List.of("Tomato", "Onions"));
        } else if (type.equals("clam")) {
            return new NYStyleClamPizza("NYStyleClamPizza", "medium", "Tomato", List.of("Tomato", "Onions"));
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza("NYStylePepperoniPizza", "medium", "Tomato", List.of("Tomato", "Onions"));
        } else return null;
    }
}
