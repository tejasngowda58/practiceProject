package practice.AdvancedDSA.BinarySearch;

import practice.AdvancedDSA.GCD.FindGCD;

public class MagicalNumber {
    public static void main(String[] args) {
        System.out.println(solve(235121015,25307,19644));
    }

    public static int solve(int A, int B, int C){
        long ans = 0;
        long l=1;
        long h= Integer.max(B, C)*A;
        long gcd = FindGCD.gcd(B, C);
        long lcm = (B*C)/gcd;
        while (l<=h){
            long mid = (l+h)/2;
            long magicalNum = (mid/B) + (mid/C) - (mid/lcm);
            if (magicalNum == A){
                ans = mid;
                h=mid-1;
            }
            else if (magicalNum<A)
                l=mid+1;
            else
                h=mid-1;
        }
        long val = ans % ((1000*1000*1000)+7);
        return (int) val;
    }
}
