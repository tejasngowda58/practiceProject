package practice.AdvancedDSA.Recursion;

public class PowerFunctModulo {
    public static void main(String[] args) {
        System.out.println(pow(76343132,69770696,91289118));
//        System.out.println(pow(2,3,3));
    }
    public static int pow(int A, int B, int C) {
        if(A==0)
            return 0;
        if (B==0)
            return 1;
        long value;
        if(B%2 == 0){
            long ans  = pow(A, B/2, C);
            value = (ans*ans)%C;
        }
        else{
            long ans  = pow(A, B/2, C);
            value = ((ans*ans)%C * A%C)%C;
        }

        if (value<0){
            return (int) (value + (long)C);
        }
        return (int) value;
    }
}
