package practice.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(solve(463));
    }
    public static int solve(int A){
        if(A==0)
            return 0;
        return solve(A/10) + A%10;
    }
}
