package practice.String;

public class AmazingArray {
    public static void main(String[] args) {
        System.out.println(solve("pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn"));
    }

    public static int solve(String A) {
        int length = A.length();
        int sum = 0;
        for (int i=0; i<length; i++){
            char data = A.charAt(i);
            if (data=='A' || data=='a' || data=='E'|| data=='e'|| data=='I'|| data=='i'|| data=='O'|| data=='o'|| data=='U'|| data=='u'){
                sum = (sum + (length-i))%10003;
            }
        }
        return sum%10003;
    }
}
