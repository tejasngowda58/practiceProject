package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxAndMinSumOfAllSubArrays {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347));
        System.out.println(smallerElementToLeft(A));
        System.out.println(smallerElementToRight(A));
        System.out.println(greaterElementToLeft(A));
        System.out.println(greaterElementToRight(A));
        System.out.println(solve(A));
    }

    public static  int solve(ArrayList<Integer> A) {
        long maxSum = 0;
        long minSum = 0;
        long mod = 1000*1000*1000+7;
        ArrayList<Integer> smallerLeft = smallerElementToLeft(A);
        ArrayList<Integer> smallerRight = smallerElementToRight(A);
        ArrayList<Integer> greaterLeft = greaterElementToLeft(A);
        ArrayList<Integer> greaterRight = greaterElementToRight(A);
        for (int i=0; i<A.size(); i++) {
            long ls = (long)smallerLeft.get(i);
            long rs = (long)smallerRight.get(i);
            long data = (long)A.get(i);
            long val1 = (data*((long)i -ls)*(rs-(long)i))%mod;
            minSum = (minSum%mod + val1)%mod;
            System.out.println(minSum);

            long lg = greaterLeft.get(i);
            long rg = greaterRight.get(i);
            long val2 = (data*((long)i -lg)*(rg-(long)i))%mod;
            maxSum = (maxSum%mod + val2)%mod;
            System.out.println(maxSum);

        }

        long ans = (maxSum-minSum);
        ans += mod;
        ans = ans%mod;
        return (int) ans;

    }

    private static ArrayList<Integer> smallerElementToLeft(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=0; i<A.size(); i++){
            while (!stack.isEmpty() && A.get(stack.peek())>=A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(-1);

            stack.push(i);
        }
        return res;
    }

    private static ArrayList<Integer> smallerElementToRight(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=A.size()-1; i>=0; i--){
            while (!stack.isEmpty() && A.get(stack.peek())>A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(A.size());

            stack.push(i);
        }

        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i= res.size()-1; i>=0; i--)
            reverse.add(res.get(i));
        return reverse;
    }

    private static ArrayList<Integer> greaterElementToLeft(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=0; i<A.size(); i++){
            while (!stack.isEmpty() && A.get(stack.peek())<=A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(-1);

            stack.push(i);
        }
        return res;
    }


    private static ArrayList<Integer> greaterElementToRight(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=A.size()-1; i>=0; i--){
            while (!stack.isEmpty() && A.get(stack.peek())<A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(A.size());

            stack.push(i);
        }

        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i= res.size()-1; i>=0; i--)
            reverse.add(res.get(i));
        return reverse;
    }
}
