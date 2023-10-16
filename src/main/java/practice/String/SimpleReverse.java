package practice.String;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleReverse {
    public static void main(String[] args) {
        System.out.println(solve("ABCD"));
    }

    public static String solve(String A) {
        int N  = A.length();
        int i=0;
        int j=N-1;
        char[] arr = A.toCharArray();

        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String s = String.valueOf(arr);
        return s;
    }
}
