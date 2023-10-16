package practice.Arrays;

public class AmazingArrays {
    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }

    public static int solve(String A) {
        int len = A.length();
        int ans = 0;
        for (int i=0; i<len; i++){
            char data = A.charAt(i);
            if(data=='a' || data=='e' || data=='i' || data=='o' || data=='u' || data=='A' || data=='E' || data=='I' || data=='O' || data=='U'){
                ans += (len-i);
                ans %= 10003;
            }
        }
        return ans;
    }
}
