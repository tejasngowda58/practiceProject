package practice.OOP;

public class Pigeon extends Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}
