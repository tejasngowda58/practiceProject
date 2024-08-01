package practice.GenericsTest;

public class Pair<T, U> {
    T left;
    U right;

    public Pair(T left, U right) {
        if (left==null || right==null){
            throw new NullPointerException("Left or right is null");
        }
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public U getRight() {
        return right;
    }

    public void setRight(U right) {
        this.right = right;
    }
}
