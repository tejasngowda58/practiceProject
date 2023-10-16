package practice.AdvancedDSA.Recursion;

public class IsMagic {
    public static void main(String[] args) {

    }

    public static int solve(int A) {
        A = sum(A);
        while (A/10 != 0){
            A = sum(A);
        }

        if (A==1)
            return 1;
        else
            return 0;
    }

    public static int sum(int A){
        if(A/10 == 0)
            return A;
        return (A%10)+sum(A/10);
    }
}
