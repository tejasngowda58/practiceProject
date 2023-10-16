package practice.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String A = "madam";
        System.out.println(checkPalindrome(A, 0, A.length()-1));
    }


    public static int checkPalindrome(String A, int i, int j){
        if(i>j)
            return 1;
        if(A.charAt(i)==A.charAt(j) && checkPalindrome(A,i+1, j-1)==1)
            return 1;
        else
            return 0;
    }
}
