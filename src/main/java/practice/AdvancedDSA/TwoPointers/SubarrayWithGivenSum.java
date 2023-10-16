package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 16;
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int p1=0;
        int p2=0;
        int sum = A.get(0);
        while (p1<A.size() && p2<A.size()){
            if (sum == B)
                break;
            else if (sum<B){
                p2++;
                if (p2<A.size())
                    sum += A.get(p2);
            }
            else {
                sum -= A.get(p1);
                p1++;
            }
        }
        if (sum == B){
            for (int i=p1; i<=p2; i++)
                res.add(A.get(i));
        }
        else
            res.add(-1);

        return res;
    }
}
