package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An in index is said to be special if after deleting that index,
 * sum of all even index=sum of all odd index.
 * Return the count of special index
 */

public class SpecialIndex {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(4,3,2,7,6,-2));
        System.out.println(solution(data));
    }

    public static int solution(ArrayList<Integer> data) {
        int prefixSumEven[] = new int[data.size()];
        int prefixSumOdd[] = new int[data.size()];
        int count = 0;
        prefixSumEven[0] = data.get(0);
        prefixSumOdd[0] = 0;
        for (int i=1; i< data.size(); i++){
            if (i%2==0) {
                prefixSumEven[i] = prefixSumEven[i-1]+ data.get(i);
                prefixSumOdd[i] = prefixSumOdd[i-1];
            }
            else {
                prefixSumEven[i] = prefixSumEven[i-1];
                prefixSumOdd[i] = prefixSumOdd[i-1] + data.get(i);
            }
        }
        for (int i=0; i< data.size(); i++){
            System.out.print(prefixSumEven[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i=0; i< data.size(); i++){
            System.out.print(prefixSumOdd[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i=0; i< data.size(); i++){
            int evenSum = prefixSumOdd[data.size()-1] - prefixSumOdd[i];
            if (i!=0)
                evenSum = evenSum + prefixSumEven[i-1];
            int oddSum = prefixSumEven[data.size()-1] - prefixSumEven[i];
            if (i!=0)
                oddSum = oddSum + prefixSumOdd[i-1];
            if (evenSum==oddSum)
                count++;
        }
        return count;
    }
}
