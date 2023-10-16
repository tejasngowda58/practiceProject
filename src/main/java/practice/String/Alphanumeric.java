package practice.String;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphanumeric {
    public static void main(String[] args) {
        ArrayList<Character> A = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'));
        System.out.println(solve(A));
        ArrayList<Character> B = new ArrayList<>(Arrays.asList('S', 'c', '0', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'));
        System.out.println(isAlpha(B));
    }

    public static int solve(ArrayList<Character> A) {
        int length = A.size();
        for (int i=0; i<length; i++){
            int data = A.get(i)+0;
            if ((data>=48 && data<=57) || (data>=65 && data<=90) || (data>=97 && data<=122)){
                continue;
            }
            else
                return 0;
        }
        return 1;
    }

    public static int isAlpha(ArrayList<Character> A) {
        int length = A.size();
        for (int i=0; i<length; i++){
            int data = A.get(i)+0;
            if ((data>=65 && data<=90) || (data>=97 && data<=122)){
                continue;
            }
            else
                return 0;
        }
        return 1;
    }

}
