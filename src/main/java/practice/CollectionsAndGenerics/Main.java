package practice.CollectionsAndGenerics;

import practice.AdvancedDSA.Arrays.Flip0s;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("cat", "cat"));
        cats.add(new Cat("cat", "kitten"));
        cats.add(new Cat("cat", "kitty"));

        for (Cat cat: cats){
            System.out.println(cat.name);
        }
//        cats.sort(null);
        order(cats);
        System.out.println();
        for (Cat cat: cats){
            System.out.println(cat.name);
        }
    }

    public static <T extends Animal & Comparable> void order(List<T> list){
        list.sort(null);
    }
}
