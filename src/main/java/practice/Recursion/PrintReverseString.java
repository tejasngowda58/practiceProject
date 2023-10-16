package practice.Recursion;

public class PrintReverseString {
    public static void main(String[] args) {
        String A = "cool";
        rev(A, 0);
    }

    public static void rev(String A, int n){
        if (n == A.length())
            return;
        rev(A, n+1);
        System.out.print(A.charAt(n));
    }
}
