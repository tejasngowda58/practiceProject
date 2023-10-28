package practice.HeadFirstDesignPatterns.SimuDuck;

public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack!! Quack!!");
    }
}
