package practice.AdvancedDSA.Combinatrics;

public class nCrModP {
    public static void main(String[] args) {

    }

    public static int solve(int A, int B, int C) {
        long a[]=new long[A+1];
        long fact=1;
        a[0]=1;
        for(int i=1;i<=A;i++){
            a[i]=( (a[i-1]%C) * (i%C) )%C;
            a[i]%=C;
        }
        long num=a[A] %C;

        /*
            Applied Little fermat Theorem

            A POW P=A MOD P

            A POW P-2= (A POW -1) MOD P

            in our case,

            A POW P-2 is Math.pow(a[A-B] * a[B], C-2)
        */
        long k=( (a[A-B]%C) * (a[B]%C) )%C;
        long power=pow(k, C-2, C);
        long temp=( (num%C) * (power%C) ) %C;
        return (int)temp;

    }

    public static long pow(long A, int B, int C) {
        if(A==0) return 1;
        if(B==0) return 1;
        if(B==1) return (A+C) %C;

        long half=pow(A, B/2, C);
        if(B%2==0){
            return ( (half%C) * (half%C) )%C;
        }else{
            return  ( (half%C) * ((half * A)%C) )%C;
        }
    }

}
