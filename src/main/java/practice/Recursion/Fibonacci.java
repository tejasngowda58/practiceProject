package practice.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(findAthFibonacci(9));
    }

    public static int findAthFibonacci(int A) {
        if (A<2)
            return A;
        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
}
