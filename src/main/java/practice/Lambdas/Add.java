package practice.Lambdas;

import java.util.Iterator;

public class Add implements  MathOperation {
    @Override
    public int operate(int a, int b) {
        return a+b;
    }
}
