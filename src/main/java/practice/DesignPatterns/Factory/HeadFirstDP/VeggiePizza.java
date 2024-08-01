package practice.DesignPatterns.Factory.HeadFirstDP;

import java.util.List;

public class VeggiePizza extends Pizza {
    public VeggiePizza(String name, String dough, String sauce, List<String> toppings) {
        super(name, dough, sauce, toppings);
    }
}
