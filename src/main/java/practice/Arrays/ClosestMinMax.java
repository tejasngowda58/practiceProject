package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestMinMax {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new  ArrayList<>(Arrays.asList(1, 6, 4, 6, 5, 1, 5, 2, 6, 4 ,4 ,2 ,1, 5));
        ArrayList<Integer> A = new  ArrayList<>(Arrays.asList(4,4,4,4,4));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int ans = A.size();
        int min = 2001;
        int max = -2001;
        int mini = -1;
        int maxi = -1;
        for (int num: A){
            if (num < min)
                min = num;
            if (num>max)
                max = num;
        }

        if(max==min)
            return 1;
        for (int i=A.size()-1; i>=0; i--){
            int len = 0;
            if (A.get(i) == min){
                mini = i;
                if (maxi!=-1){
                    len = maxi - mini +1;
                    if (ans>len)
                        ans=len;
                }
            }
            else if (A.get(i) == max){
                maxi = i;
                if (mini != -1){
                    len = mini - maxi + 1;
                    if (ans>len)
                        ans = len;
                }
            }
        }
//        System.out.println(max);
        return ans;
    }
}
