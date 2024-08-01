package practice.Revison.BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FindFloorOfANumber {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(List.of(0,2,4,5,8,9,12,13,15,20,30,51));
        System.out.println(solution(array, 111));
    }

    public static int solution(List<Integer> array, int k){
        int l=0;
        int h = array.size()-1;
        int mid = 0 ;
        int ans = Integer.MIN_VALUE;

        while(h>=l){
            mid = (l+h)/2 ;
            if (array.get(mid)==k)
                return k;
            else if (array.get(mid)>k)
                h=mid-1;
            else
            {
                ans = array.get(mid);
                l = mid+1;
            }
        }
        return ans;
    }
}
