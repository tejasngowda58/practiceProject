package practice.test4;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example :
 * 	Input	: nums = [0,1,0,3,12]
 * 	Output	: [1,3,12,0,0]
 *
 * 	Input	: nums = [0]
 * 	Output	: [0]
 */

public class Main {
    public static void main(String[] args) {
        int [] input  = new int[] {0,0,1,0,2,0,3,0,4,0,5,0};
//        int [] input  = new int[] {0};
        solution(input);
    }

    public static void solution(int [] input){
        int length =  input.length;
        boolean isZeroAlreadyFound = false;
        int zeroPosition = -1;
        int pointer = 0;

        while (pointer<length){
            if (input[pointer]==0 && isZeroAlreadyFound==false){
                zeroPosition = pointer;
                pointer++;
                isZeroAlreadyFound = true;
            }
            else {
                if (input[pointer]==0)
                    pointer++;
                else {
                    if (zeroPosition==-1){
                        pointer++;
                        continue;
                    }
                    input[zeroPosition] = input[pointer];
                    input[pointer] = 0;
                    pointer = zeroPosition;
                    pointer++;
                    isZeroAlreadyFound = false;
                }
            }
        }

        for (int i=0; i<length; i++)
            System.out.println(input[i]);

    }
}
