package practice.CollectionsAndGenerics;

public class Dog extends Animal{
    protected Dog(String type, String name) {
        super(type, name);
        System.out.println("Initialized the Dog constructor");
    }

    @Override
    public String makeSound() {
        return "Bow Bow";
    }
}
