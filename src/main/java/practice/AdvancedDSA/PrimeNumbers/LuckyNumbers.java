package practice.AdvancedDSA.PrimeNumbers;

public class LuckyNumbers {
    public static void main(String[] args) {
        System.out.println(solve(12));
    }

    public static int solve(int A) {
        int ans = 0;
        int arr[] = new int[A+1];
        for (int i=2; i<=A; i++){
            if (arr[i] == 0){
                for(int j=i*2; j<=A; j=j+i){
                    arr[j] = arr[j] +1;
                }
            }
        }
        for (int i=2; i<=A; i++){
            if (arr[i] ==2)
                ans++;
        }
        return ans;
    }
}
