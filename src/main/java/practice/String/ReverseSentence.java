package practice.String;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(solve("ab cd ef   "));
    }

    public static String solve(String A) {
        StringBuilder result = new StringBuilder();
        int length = A.length();
        int p1=length-1;
        while (A.charAt(p1) == ' '){
            p1--;
        }
        int p2=p1;
        while (p1>0){
            if (result.length() !=0)
                result.append(" ");
            while (p1>0 && A.charAt(p1-1) != ' '){
                p1--;
            }
            int i=p1;
            while (i<=p2){
                result.append(A.charAt(i));
                i++;
            }
            p2 = p1-1;
            while (p1>0 && A.charAt(p2) == ' '){
                p2--;
            }
            p1--;
        }

        return result.toString();
    }
}
