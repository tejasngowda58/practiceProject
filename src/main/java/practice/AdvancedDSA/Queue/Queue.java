package practice.AdvancedDSA.Queue;

import java.util.Stack;

public class Queue {

    public static class UserQueue {
        /** Initialize your data structure here. */
        public static Stack<Integer> primary;
        public static Stack<Integer> secondary;

        UserQueue() {
            primary = new Stack<>();
            secondary = new Stack<>();
        }

        /** Push element X to the back of queue. */
        static void push(int X) {
            primary.push(X);
        }

        /** Removes the element from in front of queue and returns that element. */
        static int pop() {
            while (!primary.isEmpty())
                secondary.push(primary.pop());
            return secondary.pop();
        }

        /** Get the front element of the queue. */
        static int peek() {
            while (!primary.isEmpty())
                secondary.push(primary.pop());
            return secondary.peek();
        }

        /** Returns whether the queue is empty. */
        static boolean empty() {
            return (primary.empty() && secondary.empty());
        }
    }
}


