package practice.AdvancedDSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(9, 9 ,9, 9));
        System.out.println(plusOne1(A));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        boolean flag = false;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            if (A.get(i) == 0 && !flag && A.size()!=1)
                continue;
            else {
                flag = true;
                    result.add(A.get(i));
            }
        }
        A = new ArrayList<>();
        int carry = 0;
        int sum = 0;
        int digit = 0;
        for (int i=result.size()-1; i>=0; i--){
            if (i== result.size()-1){
                sum = result.get(i)+1;
                digit = sum%10;
                carry = sum/10;
                A.add(digit);
                continue;
            }
            if (carry == 1){
                sum = result.get(i)+carry;
                digit = sum%10;
                carry = sum/10;
                A.add(digit);
            }
            else {
                A.add(result.get(i));
            }
        }
        if (carry ==1){
            A.add(carry);
        }
        Collections.reverse(A);
        return A;
    }

    public static ArrayList<Integer> plusOne1(ArrayList<Integer> A) {
//        ArrayList<Integer> result = new ArrayList<>();
        int carry=0;
        int sum=0;
        int digit = 0;
        int size = A.size();
        for (int i=size-1; i>=0; i--){
            if (i== size-1){
                sum = A.get(i)+1;
            }
            else {
                sum = A.get(i)+carry;
            }
            digit = sum%10;
            carry = sum/10;
            A.set(i, digit);
        }
        if (carry==1)
            A.add(0,carry);

        while(A.size()!=0){
            if (A.get(0) == 0)
                A.remove(0);
            else {
                break;
            }
        }
        return A;
    }
}
