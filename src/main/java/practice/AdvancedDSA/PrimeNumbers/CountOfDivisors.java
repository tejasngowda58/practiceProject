package practice.AdvancedDSA.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDivisors {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10,20));
        ArrayList<Integer> res = solve(A);
        for (int i=0;i< res.size(); i++)
            System.out.println(res.get(i));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        int count = 0;
        ArrayList<Integer> divisors = new ArrayList();

        for (int j=0; j<A.size(); j++){
            count=0;
            for (int i=1; i<=Math.sqrt(A.get(j)); i++){

                if(A.get(j)%i==0){
                    if (A.get(j)/i == i)
                        count++;
                    else
                        count=count+2;
                }
            }
            divisors.add(count);
        }

        return divisors;
    }
}
