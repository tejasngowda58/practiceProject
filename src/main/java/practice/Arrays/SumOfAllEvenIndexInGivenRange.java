package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfAllEvenIndexInGivenRange {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(3,2,1,6,-3,2,8,4,9));
        System.out.println(solution(data, 3,8));
    }

    public static int solution(ArrayList<Integer> data, int left, int right) {
        int evenPrefixSum[] = new int[data.size()];
        evenPrefixSum[0] = data.get(0);
        for (int i=1; i<data.size(); i++){
            if (i%2==0)
                evenPrefixSum[i] = evenPrefixSum[i-1] + data.get(i);
            else
                evenPrefixSum[i] = evenPrefixSum[i-1];
        }
        if (left==0)
            return evenPrefixSum[right];
        else
            return evenPrefixSum[right]-evenPrefixSum[left-1];
    }
}
