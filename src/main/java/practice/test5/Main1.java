package practice.test5;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        int[] a = new int[] {5,3,6,8,1,9,5,2,8};
        int[] b = new int[] {4,5,8,2,3,1};
        solution(a,b);
    }

    public static void solution(int[] a, int[] b){
        sortArray(a);
        sortArray(b);
        int arrayLength = Math.min(a.length, b.length);
        List<Integer> sortedArray = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<a.length && j<b.length){
            if (a[i]<b[j]){
                sortedArray.add(a[i]);
                i++;
            }else {
                sortedArray.add(b[j]);
                j++;
            }
        }

        while (i<a.length){
            sortedArray.add(a[i]);
            i++;
        }

        while (j<b.length){
            sortedArray.add(b[j]);
            j++;
        }

        System.out.println(sortedArray);
    }

    public static void sortArray(int [] input){
        int size = input.length;

        for (int i=0; i<size-1; i++){
            for (int j=0; j<size-1; j++){
                if (input[j]>input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
        for (int i=0; i<size; i++){
            System.out.println(input[i]);
        }
    }
}
