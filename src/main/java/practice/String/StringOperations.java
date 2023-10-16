package practice.String;

public class StringOperations {
    public static void main(String[] args) {
        System.out.println(solve("AbcaZeoB"));
    }

    public static String solve(String A){
        String concat = A.concat(A);
        StringBuilder res = new StringBuilder();
        int length = concat.length();
        for (int i=0; i<length; i++){
            int data = concat.charAt(i) + 0;
            if(data >=65 && data <=90){
                continue;
            }
            else {
                char val = concat.charAt(i);
                if (val == 'a' || val == 'e' || val == 'i' || val == 'o' || val =='u')
                    res.append('#');
                else
                    res.append(val);
            }
        }
        return res.toString();
    }
}
