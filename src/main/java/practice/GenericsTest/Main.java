package practice.GenericsTest;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair;
        try {
            pair = new Pair<>("left", null);
            System.out.println(pair.getLeft()+" "+ pair.getRight());
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException");
            throw new NullPointerException("Hi");
        }

        Pair<String, String> pair1 = new Pair<>("s1", "s2");
        System.out.println(pair1.getLeft()+" "+ pair1.getRight());
        Utility.swap(pair1);
        System.out.println(pair1.getLeft()+" "+ pair1.getRight());
    }
}
