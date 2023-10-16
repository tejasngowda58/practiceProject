package practice.AdvancedDSA.LinkedList;

public class MergeSort {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 4);
        utils.insert(head, 3);
        utils.insert(head, 6);
        utils.insert(head, 5);

        LLUtils.ListNode mid = findMid(head);
        head = mergeSort(head);
        LLUtils.printLinkedList(head);
        System.out.println("Mid is: " + mid.val);
    }

    public static LLUtils.ListNode mergeSort(LLUtils.ListNode head){
        if (head==null || head.next==null)
            return head;
        LLUtils.ListNode mid = findMid(head);
        LLUtils.ListNode head2 = mid.next;
        mid.next = null;
        head = mergeSort(head);
        head2 = mergeSort(head2);
        return merge(head, head2);
    }

    public static LLUtils.ListNode findMid(LLUtils.ListNode head) {
        if (head!= null && head.next!=null && head.next.next == null)
            return head;
        LLUtils.ListNode fast = head;
        LLUtils.ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static LLUtils.ListNode merge(LLUtils.ListNode h1, LLUtils.ListNode h2){
        LLUtils.ListNode head;
        if (h1.val <= h2.val){
            head = h1;
        }
        else {
            head = h2;
            h2=h1;
            h1=head;
        }

        while (h1.next!=null){
            if (h1.next.val > h2.val){
                LLUtils.ListNode temp = h1.next;
                h1.next = h2;
                h1 = h2;
                h2 = temp;
            }
            else {
                h1 = h1.next;
            }
        }

        if (h1.next == null) {
            h1.next = h2;
        }
        return head;
    }
}
