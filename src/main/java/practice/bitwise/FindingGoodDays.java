package practice.bitwise;

public class FindingGoodDays {
    public static void main(String[] args) {
        System.out.println(solve(7));
    }

    public static int solve(int A) {
        int count = 0;
        for(int i=0; i<32; i++){
            if ((A>>i & 1)==1)
                count++;
        }
        return count;
    }
}
