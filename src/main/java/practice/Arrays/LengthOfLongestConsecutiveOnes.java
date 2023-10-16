package practice.Arrays;

public class LengthOfLongestConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(solve("111010011"));
    }

    public static int solve(String A) {
        int length  = A.length();
        String[] split = A.split("");
        int ans=0;
        int countOfOnes=0;
        for (int i=0; i<length; i++){
            if (Integer.parseInt(split[i])==1)
                countOfOnes++;
        }
        if (countOfOnes==length)
            return length;

        for (int i=0; i<length; i++){
            int val = Integer.parseInt(split[i]);
            if (val==0){
                int l=0;
                for (int j=i-1; j>=0; j--){
                    if (Integer.parseInt(split[j])==1)
                        l++;
                    else
                        break;
                }
                int r=0;
                for (int j=i+1; j<length; j++){
                    if (Integer.parseInt(split[j])==1)
                        r++;
                    else
                        break;
                }
                if ((l+r)<countOfOnes) {
                    ans = Integer.max(ans, (l + r + 1));
                }
                else {
                    ans = Integer.max(ans, l+r);
                }
            }
        }
        return ans;
    }
}
