package practice.AdvancedDSA.LinkedList;

public class LLUtils {
    public ListNode insert(ListNode head, int x) {
        ListNode ref = head;
        ListNode node = new ListNode(x);
        if (head == null){
            head = node;
            return head;
        }
        while (ref.next!=null){
            ref = ref.next;
        }
        ref.next = node;
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode temp = head;
        if (temp == null)
            return;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static int length(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
}

