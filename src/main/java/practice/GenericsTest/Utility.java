package practice.GenericsTest;

public class Utility {
    public static <T> void swap(Pair<T,T> pair){
        T temp = pair.getLeft();
        pair.setLeft(pair.getRight());
        pair.setRight(temp);
    }
}
