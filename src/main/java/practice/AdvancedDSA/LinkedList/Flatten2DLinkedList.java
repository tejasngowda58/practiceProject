package practice.AdvancedDSA.LinkedList;

public class Flatten2DLinkedList {
    public static void main(String[] args) {
        ListNode1 head =  new ListNode1(3);
        head.down = new ListNode1(7);
        head.down.down = new ListNode1(7);
        head.down.down.down = new ListNode1(8);
        head.right = new ListNode1(4);
        head.right.down = new ListNode1(11);
        head.right.right = new ListNode1(20);
        head.right.right.down = new ListNode1(22);
        head.right.right.right = new ListNode1(20);
        head.right.right.right.down = new ListNode1(20);
        head.right.right.right.down.down = new ListNode1(28);
        head.right.right.right.down.down.down = new ListNode1(39);
//        head.right = new ListNode1(30);
//        head.down = new ListNode1(31);
//        head.down = new ListNode1(39);
        head = flatten(head);
        printLL(head);
    }

    private static void printLL(ListNode1 head) {
        ListNode1 temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.down;
        }
    }

    public static ListNode1 flatten(ListNode1 head) {
        if (head == null || head.right==null)
            return head;

        ListNode1 mid = findMid(head);
        ListNode1 h2 = mid.right;
        mid.right = null;
        head = flatten(head);
        h2 = flatten(h2);
        return mergeSortedLL(head, h2);
    }

    private static ListNode1 mergeSortedLL(ListNode1 h1, ListNode1 h2) {
        ListNode1 head;
        if (h1.val <= h2.val)
            head = h1;
        else {
            head = h2;
            h2 = h1;
            h1 = head;
        }
        while (h1.down != null) {
            if (h1.down.val > h2.val) {
                ListNode1 temp = h1.down;
                h1.down = h2;
                h2 = temp;
            }
            else {
                h1 = h1.down;
            }
        }
        if (h1.down == null)
            h1.down = h2;

        return head;
    }

    public static ListNode1 findMid(ListNode1 head) {
        if (head == null || head.right==null)
            return head;
        ListNode1 fast = head;
        ListNode1 slow = head;
        while (fast.right!=null && fast.right.right!=null){
            fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }

    static class ListNode1 {
        int val;
        ListNode1 right, down;
        ListNode1(int x) {
            val = x;
            right = down = null;
        }
    }
}
