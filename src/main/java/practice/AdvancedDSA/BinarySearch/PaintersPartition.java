package practice.AdvancedDSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(658, 786, 531, 47, 169, 397, 914));
        System.out.println(paint(5, 10, data));
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {
        if (C.size() <= A){
            return B*maxOfElements(C);
        }
        long l =1;
        long h = sumOfElements(C);
        long ans = 0;
        while (l<=h){
            long mid = (l+h)/2;
            if(isTimeValid(C, mid, A)){
                ans = mid;
                h = mid-1;
            }
            else {
                l=mid+1;
            }
        }
        long mod = 10000003;
        long result = (ans*B)%mod;
        return (int) result;
    }

    public static int sumOfElements(ArrayList<Integer> C){
        int sum = 0;
        for (int data: C){
            sum += data;
        }
        return sum;
    }

    public static boolean isTimeValid(ArrayList<Integer> C, long time, int painters){
        int sum =0;
        int count = 0;
        for (int i=0; i<C.size(); i++){
            sum += C.get(i);
            if (sum>time){
                sum = C.get(i);
                if (sum > time)
                    return false;
                count++;
            }
        }
        if (C.get(C.size()-1) > time)
            return false;
        count++;
        System.out.print(count);
        System.out.print(" ");
        System.out.print(time);
        System.out.println();
        if (count<=painters)
            return true;
        return false;
    }

    public static int maxOfElements(ArrayList<Integer> C){
        int data = C.get(0);
        for (int i=1; i<C.size(); i++){
            if (data < C.get(i))
                data = C.get(i);
        }
        return data;
    }
}
