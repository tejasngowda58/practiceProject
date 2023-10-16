package practice.AdvancedDSA.BitManipulation;

/*
Write a function that takes an integer and returns the number of 1 bits it has.
 */

public class NumOfSetBits {
    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }
    public static int numSetBits(int A) {
        int count = 0;

        for(int i=0;i<32;i++){
            if(checkBitIsSet(A, i))
                count++;
        }
        return count;
    }
    public static boolean checkBitIsSet(int num, int bit){
        if((num>>bit & 1) == 1)
            return true;
        else
            return false;
    }
}
