package practice.AdvancedDSA.GCD;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(solve(6,1,4));
    }

    public static int solve(int A, int B, int C) {
        int gcd = gcd(B,C);
        int lcm = B*C/gcd;
        return A/lcm;
    }

    public static int gcd(int A, int B) {
        if (B==0)
            return A;
        return gcd(B, A%B);
    }
}
