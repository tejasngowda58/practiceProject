package practice.Basics;

public class MultiplicationTable {
    public static void main(String[] args) {
        solve(2);
    }

    public static void solve(int A) {
        for (int i=1; i<=10; i++){
            System.out.println("" + A +" * " + i + " = " + (A*i));
        }
    }
}
