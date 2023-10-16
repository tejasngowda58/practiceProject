package practice.AdvancedDSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    public static ArrayList<Integer> grayCode(int a) {
        if (a == 1)
            return new ArrayList<>(Arrays.asList(0,1));
        ArrayList<Integer> data = grayCode(a-1);
        ArrayList<Integer> result = new ArrayList<>();
        for (int num: data)
            result.add(num);
        for (int i=data.size()-1; i>=0;i--)
            result.add(data.get(i)+(1<<(a-1)));
        return result;
    }
}
