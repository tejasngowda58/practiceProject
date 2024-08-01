package practice.Lambdas;

public class Client {
    public static void main(String[] args) {
        MathOperation operation = new Add();
        MathOperation operation1 = Integer::sum;
//        MathOperation operation2 = Integer::sum;
        System.out.println(operation.operate(5, 6));
    }
}
