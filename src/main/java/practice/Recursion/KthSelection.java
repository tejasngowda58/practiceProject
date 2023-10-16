package practice.Recursion;

public class KthSelection {
    public static void main(String[] args) {
        System.out.println(solve(2,2));
    }

    public static int solve(int N, int k){
        if(k==1)
            return 0;
        int p = solve(N-1, (k+1)/2);
        if (k%2!=0) return p;
        else return 1-p;
    }
}
