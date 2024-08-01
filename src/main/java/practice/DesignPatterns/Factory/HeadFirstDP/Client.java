package practice.DesignPatterns.Factory.HeadFirstDP;

public class Client {
    public static void main(String[] args) {
        getPizza("Veggie");
    }

//    public static void getPizza(String type){
//        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
//        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
//        pizzaStore.orderPizza(type);
//    }
}
