package practice.Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }
    public static int solve(int A){
        if (A == 1)
            return 1;
        return solve(A-1)*A;
    }
}
