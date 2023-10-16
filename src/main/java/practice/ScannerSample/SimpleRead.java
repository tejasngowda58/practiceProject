package practice.ScannerSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleRead {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
//        Scanner sc = new Scanner(System.in);
//        int A = sc.nextInt();
//        System.out.println(A);
//        // int i = 2;
//        boolean flag = true;
//        for(int i=2; i<A/2; i++){
//            if(A%i == 0){
//                flag=false;
//                break;
//            }
//        }
//        if(flag)
//            System.out.println("YES");
//        else
//            System.out.println("NO");

        isPerfect();
    }

    public static void isPerfect(){
        List<Integer> A = new ArrayList<>(Arrays.asList(2,4,6));
        for (int num: A){
            int sum =1;
            for (int i=2; i<=num/2; i++){
                if(num%i == 0){
                    sum += i;
                }
            }
//            System.out.println(sum);
            if (sum==num)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
