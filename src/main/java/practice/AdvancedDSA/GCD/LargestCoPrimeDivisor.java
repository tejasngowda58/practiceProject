package practice.AdvancedDSA.GCD;

public class LargestCoPrimeDivisor {
    public static void main(String[] args) {
        System.out.println(cpFact(5, 10));
    }

    public static int cpFact(int A, int B) {
        while(GCD(A,B) != 1)
        {
            A=A/GCD(A,B);
        }
        return A;
    }
    public static int GCD(int a, int b)
    {
        if(b==0)
            return a;
        return GCD(b,a%b);
    }
}
