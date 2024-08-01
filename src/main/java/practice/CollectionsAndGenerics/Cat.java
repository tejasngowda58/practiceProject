package practice.CollectionsAndGenerics;

public class Cat extends Animal implements Comparable<Cat>{
    protected Cat(String type, String name) {
        super(type, name);
        System.out.println("Initialized the Cat constructor");
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.length()-o.name.length();
    }
}
