package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class PairWithGivenSumRepeatedNums {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666));
        System.out.println(solve(A,9259332));
        System.out.println(4629666+ 4629666);
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int sum=0;
        int p1=0;
        int p2=A.size()-1;
        int count =0;
        while (p1<p2){
            sum = A.get(p1) + A.get(p2);
            if (sum==B){
                if (A.get(p1).equals(A.get(p2))){
                    int repetitions = p2-p1+1;
                    count += (repetitions*(repetitions-1)/2)%(1000*1000*1000+7);
                    break;
                }
                else {
                    int temp1=p1;
                    int count1=1;
                    while (A.get(temp1)==A.get(temp1+1)){
                        temp1++;
                        count1++;
                    }
                    p1=temp1+1;
                    int temp2=p2;
                    int count2=1;
                    if (A.get(temp2)==A.get(temp2-1)){
                        while (A.get(temp2)==A.get(temp2-1)) {
                            temp2--;
                            count2++;
                        }
                        p2=temp2-1;
                    }
                    else
                        p2--;
                    count += (count1*count2)%(1000*1000*1000+7);
                }
            }
            else if (sum>B)
                p2--;
            else
                p1++;
        }
        return count;
    }
}
