package practice.AdvancedDSA.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(stack);
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        System.out.println(arrayList);
        System.out.println(stack);

    }
}
