package practice.CollectionsAndGenerics;

public abstract class Animal {
    protected final String type;
    protected final String name;

    protected Animal(String type, String name) {
        this.type = type;
        this.name = name;
        System.out.println("Initialized abstract animal");
    }

    public abstract String makeSound();
}
