package practice.String;

import java.util.ArrayList;
import java.util.Arrays;

public class ToLower {
    public static void main(String[] args) {
        ArrayList<Character> A = new ArrayList<>(Arrays.asList('A', '{', '&', 'Z', 'c', 'd'));
        System.out.println(to_lower(A));
        System.out.println(to_upper(A));
    }
    public static ArrayList<Character> to_lower(ArrayList<Character> A) {
        int length = A.size();
        for (int i=0; i<length; i++){
            int c = A.get(i) + 0;
            if(c>=65 && c<=90){
                char character = A.get(i);
                int ch = character+0;
                ch = ch^(1<<5);
                A.set(i, (char)ch);
            }
        }
        int test = (int) ((Math.pow(2,32))-1);
        int val = test&2;
        System.out.println(val);
        return A;
    }

    public static ArrayList<Character> to_upper(ArrayList<Character> A) {
        int length = A.size();
        int allOnes = (int) ((Math.pow(2,32))-1);
        int mask = 1 << 5;
        int upperConverter = allOnes ^ mask;
        for (int i=0; i<length; i++){
            int ch = A.get(i) + 0;
            if(ch>=97 && ch<=122){
                ch = ch&upperConverter;
                A.set(i, (char)ch);
            }
        }
        return A;
    }

}
