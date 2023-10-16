package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1));
        System.out.println(maxArea(A));
    }

    public static int maxArea(ArrayList<Integer> A) {
        int ans=0;
        int p1=0, p2=A.size()-1;
        while (p1<p2){
            int height = Math.min(A.get(p1), A.get(p2));
            int width = p2-p1;
            ans = Math.max(ans, height*width);
            if (A.get(p1)<=A.get(p2))
                p1++;
            else
                p2--;
        }
        return ans;
    }
}
