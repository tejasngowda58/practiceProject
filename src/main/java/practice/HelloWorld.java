package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
//        System.out.println("Hello world");
        solution(new ArrayList<>(Arrays.asList(1, 1, 1)));
    }
    public static void solution(ArrayList<Integer> A){
//        int ans = 0;
        int N = A.size();
        for (int i=0; i<A.size()-1; i=i+2){
            int a = A.get(i);
            int b = A.get(i+1);
            A.set(i, a&b);
            A.set(i+1, a|b);
//            System.out.println(i);
        }
        if (A.size()%2 != 0){
            int a = A.get(N-2);
            int b = A.get(N-1);
            A.set(N-2, a&b);
            A.set(N-1, a|b);
        }

        int ans = A.get(0);
        for (int i=1; i<A.size(); i++) {
            System.out.println(A.get(i));
            ans = ans^A.get(i);
        }
        System.out.println();
        System.out.println(1&3);
        System.out.println(1|3);
        System.out.println( (1|3) & 5);
        System.out.println( (1|3) | 5);
        System.out.println(ans);
    }
}
