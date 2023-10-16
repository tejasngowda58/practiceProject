package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumTheDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 1, -4));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A){
        Collections.sort(A);
        long mod = (long) Math.pow(10, 9) + 7;
        long max = 0;
        long min = 0;
        for (int i=0; i<A.size(); i++){
            max += A.get(i)*pow(2,i, (int) mod);
            max %= mod;
            min += A.get(i)*pow(2,A.size()-1-i, (int) mod);
            min %= mod;
        }
        long res = ((max)%mod - (min)%mod + mod) % mod;
        return (int) res;
//        return (max-min)%mod + mod;
    }

    static long pow(int n, int p, int mod){

        if(p==0) return 1;
        if(p==1) return n;
        long pow=1;

        pow=(pow%mod * pow(n, p/2, mod))%mod;
        pow=(pow%mod * pow%mod)%mod;
        if(p%2==1){
            pow=(n%mod * pow%mod)%mod;
        }
        return pow;

    }
}
