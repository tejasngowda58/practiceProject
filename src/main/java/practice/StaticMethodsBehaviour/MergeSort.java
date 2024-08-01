package practice.StaticMethodsBehaviour;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};

        int arr2[] = {2, 2, 6, 8};


        List<Integer> arr3 = mergeArrays(arr1, arr2);
        System.out.println(arr3);
//        System.out.println("Array after merging - " + Arrays.toString(arr3));
    }

    public static List<Integer> mergeArrays(int[] arr1, int[] arr2) {
        List<Integer> arr3 = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length){
            if (arr1[i]<arr2[j]){
                arr3.add(arr1[i]);
                i++;
            }
            else {
                arr3.add(arr2[j]);
                j++;
            }
        }

        if (i!=arr1.length){
            arr3.add(arr1[i]);
            i++;
        }

        if (j!=arr2.length){
            arr3.add(arr2[j]);
            j++;
        }


        return arr3;
    }
}
