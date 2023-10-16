package practice.AdvancedDSA.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TripleTrouble {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
        System.out.println(singleNumber(A));

        System.out.println(checkBitIsSet(8, 0));
        System.out.println(checkBitIsSet(8, 3));
    }

    public static int singleNumber(final List<Integer> A) {
        int result = 0;
        int bitRange = 32;
        for (int i=0; i<bitRange; i++){
            int count=0;
            for (int num: A){
                if(checkBitIsSet(num, i))
                    count++;
            }
            if(count%3!=0){
                result += 1<<i;
            }
        }
        return result;
    }

    public static boolean checkBitIsSet(int num, int bit){
        if((num>>bit & 1) == 1)
            return true;
        else
            return false;
    }
}
