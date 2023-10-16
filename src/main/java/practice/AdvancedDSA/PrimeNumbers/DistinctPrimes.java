package practice.AdvancedDSA.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctPrimes {
    public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5));
            System.out.println(solve(A));
    }

    private static int[] spf(int n){
        int[] spf = new int[n + 1];
        spf[0] = 1;
        spf[1] = 1;
        for(int i=2;i<=n;i++) spf[i] = i;
        for(int i=2;i*i<=n;i++){
            if(spf[i] == i){
                for(int j=i*i;j<=n;j+=i){
                    spf[j] = Math.min(spf[j],i);
                }
            }
        }
        return spf;
    }
    public static int solve(ArrayList<Integer> A) {
        int maxel = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            maxel = Math.max(maxel, A.get(i));
        }
        int[] spf = spf(maxel);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.size(); i++) {
            int n = A.get(i);
            while (n > 1) {
                int u = spf[n];
                while (n % u == 0) {
                    n /= u;
                }
                set.add(u);
            }
        }
        return set.size();
    }
}
