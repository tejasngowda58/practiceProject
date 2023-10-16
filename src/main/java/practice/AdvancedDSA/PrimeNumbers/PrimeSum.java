package practice.AdvancedDSA.PrimeNumbers;

import java.util.ArrayList;

public class PrimeSum {
    public static void main(String[] args) {
        System.out.println(primesum(1048574));;
    }

    public static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean primesArray[] = new boolean[A+1];
        primesArray[1] = true;
        for (int i=2; i<=A;i++){
            if (primesArray[i] == false){
                for (int j=i*i; j<=A && j>=2; j=j+i){
                    primesArray[j] = true;
                }
            }
        }

        for (int i=2; i<=A; i++){
            if(isPrime(i, primesArray) && isPrime(A-i, primesArray)) {
                result.add(i);
                result.add(A-i);
                break;
            }
        }
        return result;
    }

    public static boolean isPrime(int n, boolean[] arr){
        return !arr[n];
    }
}
