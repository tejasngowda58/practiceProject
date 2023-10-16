package practice.AdvancedDSA.GCD;

public class FindGCD {
    public static void main(String[] args) {
        System.out.println(gcd(10,9));
    }

    public static int gcd(int A, int B) {
        if (B==0)
            return A;
        return gcd(B, A%B);
    }
}
