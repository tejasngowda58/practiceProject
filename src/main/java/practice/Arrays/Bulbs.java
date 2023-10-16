package practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {
    public static void main(String[] args) {
        ArrayList<Integer> A = new  ArrayList<>(Arrays.asList(1,0,0,0,0,0));
        System.out.println(bulbs(A));
    }
    public static int bulbs(ArrayList<Integer> A) {
        int ans = 0;
        int state = 0;
        for (int num: A){
            if (state == num) {
                ans++;
                state = (state == 0) ? 1 : 0;
            }
        }

        return ans;
    }
}
