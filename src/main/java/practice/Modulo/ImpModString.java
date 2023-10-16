package practice.Modulo;

public class ImpModString {
    public static void main(String[] args) {
        System.out.println(solve("43535321", 47));
    }

    public static int solve(String A, int B) {
        long ans = 0L;
        int singleMod = 1;
        int N=A.length();
        for (int i=N-1; i>=0; i--){
            ans += ((A.charAt(i) - 48)*singleMod)%B;
            singleMod = (singleMod*10)%B;
        }
        int val = (int)ans%B;
        return val;
    }
}
