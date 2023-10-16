package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9));
        System.out.println(books(A, 5));
    }

    public static int books(ArrayList<Integer> A, int B) {
        if (A.size()<B)
            return -1;
        int l=1;
        int h=sumOfElements(A);
        int ans=0;
        while (l<=h){
            int mid = (l+h)/2;
            if (checkIsPagesValid(A, B, mid)){
                h= mid-1;
                ans=mid;
            }
            else {
                l = mid+1;
            }
        }
        return ans;
    }

    public static int sumOfElements(ArrayList<Integer> C){
        int sum = 0;
        for (int data: C){
            sum += data;
        }
        return sum;
    }

    public static boolean checkIsPagesValid(ArrayList<Integer> A, int students, int value){
        int count = 0;
        int sum = 0;
        for (int i=0; i<A.size(); i++){
            sum += A.get(i);
            if (sum>value){
                sum = A.get(i);
                if (sum>value)
                    return false;
                count++;
            }
        }
        count++;
        if (count<=students)
            return true;
        return false;

    }
}
