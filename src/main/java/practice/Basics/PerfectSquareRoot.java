package practice.Basics;

public class PerfectSquareRoot {
    public static void main(String[] args) {
        System.out.println(solve(49));
    }

    public static int solve(int A) {
        int i=2;
        while (i*i <=A){
            if(A/(i*i)==1 && A%(i*i)==0){
                return i;
            }
            i++;
        }
        return -1;
    }
}
