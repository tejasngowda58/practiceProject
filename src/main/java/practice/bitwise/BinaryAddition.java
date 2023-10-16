package practice.bitwise;

public class BinaryAddition {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
    }

    public static String addBinary(String A, String B) {
        StringBuilder res = new StringBuilder();
        int lenA = A.length()-1;
        int lenB = B.length()-1;
        int carry = 0;
        int digit = 0;
        while (lenA>=0 || lenB>=0){
            int num1 = 0;
            if(lenA>=0) {
                char data1 = A.charAt(lenA);
                String s = String.valueOf(data1);
                num1 = Integer.parseInt(s);
            }
            int num2 = 0;
            if(lenB >= 0) {
                char data2 = B.charAt(lenB);
                String s = String.valueOf(data2);
                num2 = Integer.parseInt(s);
            }
//            System.out.println(num1);
//            System.out.println(num2);
            int sum = num1 + num2 + carry;
            carry = sum/2;
            digit = sum%2;
            res.append(digit);
            lenA--;
            lenB--;
        }
        if(carry!=0)
            res.append(carry);
        res.reverse();
        return res.toString();
    }
}
