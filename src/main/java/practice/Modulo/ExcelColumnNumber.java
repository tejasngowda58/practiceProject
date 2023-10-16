package practice.Modulo;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(solve("AA"));
//        System.out.println('1'-48);
        System.out.println(solve1("8"));
    }


    public static int solve(String A){
        int ans = 0;
        int mul = 1;
        int N=A.length();
        for (int i=N-1; i>=0; i--){
            ans += mul*(A.charAt(i)-'A' +1);
            mul *= 26;
        }
        return ans;
    }

    public static int solve1(String A) {
//        int ans = 0;
        int val=0;
        int mul=1;
        int i=A.length()-1;
        while (i>=0 && i>=A.length()-3){
            val += mul*A.charAt(i)-48;
            mul*=10;
            i--;
        }
        if (val%8 ==0){
            return 0;
        }
        return 1;
    }
}
