package practice.test3;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{-1, -6, -7, 0, 0, 9, 0, 9};
        solution(input);
    }

    public static void solution(int [] input){
        int size = input.length;
        boolean isZeroAlreadyEncountered = false;
        int zerothPosition = -1;
        int pointer = 0;

        while (pointer<size){
            if (input[pointer]==0 && isZeroAlreadyEncountered==false){
                zerothPosition = pointer;
                isZeroAlreadyEncountered = true;
                pointer++;
            }
            else {
                if (input[pointer]==0) {
                    pointer++;
                    continue;
                }
                if (zerothPosition!=-1) {
                    input[zerothPosition] = input[pointer];
                    input[pointer] = 0;
                    pointer = zerothPosition+1;
                    isZeroAlreadyEncountered = false;
                }
                else{
                    pointer ++;
                }
            }
        }
        for (int i=0; i<size; i++)
            System.out.println(input[i]);
    }
}
