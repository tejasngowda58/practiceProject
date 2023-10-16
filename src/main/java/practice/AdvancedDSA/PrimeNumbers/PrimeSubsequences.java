package practice.AdvancedDSA.PrimeNumbers;

import java.util.ArrayList;

public class PrimeSubsequences {
    public static void main(String[] args) {

    }

    public static int solve(ArrayList<Integer> A) {
        int constraint = (int)1e6 + 1;
        int[] sieve = new int[constraint];
        sieve[0] = -1;
        sieve[1] = -1;
        for (int i = 2; i* i < constraint; i++) {
            if (sieve[i] == 0) {
                for (int j = i *i; j < constraint; j += i) {
                    sieve[j] = -1;
                }
            }
        }

//Step2) Counting number of primes present in Array
        int countOfPrimes = 0;
        int N = A.size();
        for (int i = 0; i < N; i++) {
            countOfPrimes += (sieve[A.get(i)] == 0) ? 1 : 0;
        }

//Step3) 2^(Number of primes) - 1
        return fastPower(2, countOfPrimes, (int)1e9 + 7) - 1;
    }

    public static int fastPower(long A, long B, long mod) {
        long res = 1;
        while (B > 0) {
            if ((B & 1) != 0) {
                res = (res % mod * A % mod) % mod;
                B = B - 1;
            }
            A = (A % mod * A % mod) % mod;
            B = B / 2;
        }
        return (int)res;
    }
}
