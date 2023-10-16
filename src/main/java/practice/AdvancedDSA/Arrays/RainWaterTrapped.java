package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println(trap(A));
    }

    public static int trap(final List<Integer> A) {
//        if()
        int answer = 0;
        int length = A.size();
        int prefixMax[] = new int[A.size()];
        int suffixMax[] = new int[length];

        prefixMax[0] = A.get(0);
        for(int i=1; i<length; i++){
            prefixMax[i] = Integer.max(A.get(i), prefixMax[i-1]);
        }

        System.out.println("prefixMax: ");
        for (int i: prefixMax)
            System.out.print(i + " ");
        System.out.println();

        suffixMax[length-1] = A.get(length-1);
        for (int i=length-2; i>=0;i--){
            suffixMax[i] = Integer.max(A.get(i), suffixMax[i+1]);
        }

        System.out.println("suffixMax: ");
        for (int i: suffixMax)
            System.out.print(i + " ");
        System.out.println();

        for (int i=1; i<length-1; i++){
            int MaxLeft = prefixMax[i-1];
            int MaxRight = suffixMax[i+1];
            int waterLevel = Integer.min(MaxLeft, MaxRight);
            int waterLevelofBuilding = Integer.max(0,waterLevel-A.get(i));
            System.out.println("waterLevelofBuilding: " + waterLevelofBuilding);
            answer += waterLevelofBuilding;
        }
        return answer;
    }
}
