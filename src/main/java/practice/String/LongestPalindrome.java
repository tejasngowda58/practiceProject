package practice.String;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("aaaabaaa"));
    }
    public static String solve(String A){
        StringBuilder result = new StringBuilder();
        int length = A.length();
        int max = 0;
        for (int i=0; i<length;i++){
            int p1,p2;
            p1=p2=i;
            String temp = expand(A, p1,p2, max);
            if (temp.length()!=0){
                result = new StringBuilder(temp);
                max = result.length();
            }
        }

        for (int i=0; i<length-1;i++){
            int p1,p2;
            p1=i;
            p2=i+1;
            String temp = expand(A, p1,p2, max);
            if (!temp.isBlank()){
                result = new StringBuilder(temp);
                max = result.length();
            }
        }
        return result.toString();
    }

    private static String expand(String A, int p1, int p2, int max){
        StringBuilder result = new StringBuilder();
        int currentLength = 0;
        while (p1>=0 && p2<A.length() && A.charAt(p1)==A.charAt(p2)){
            p1--;
            p2++;
        }
        p1++;
        p2--;
        currentLength = p2-p1+1;
        if (max < currentLength) {
            max = currentLength;
            while (p1 <= p2) {
                result.append(A.charAt(p1));
                p1++;
            }
        }
        return result.toString();
    }
}
