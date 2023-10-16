package practice.AdvancedDSA.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
//        utils.insert(head, 2);
//        utils.insert(head, 3);
//        utils.insert(head, 3);
        utils.insert(head, 3);
        utils.insert(head, 2);
        utils.insert(head, 1);
        System.out.println(isPalindrome(head));
    }

    public static int isPalindrome(LLUtils.ListNode head){
        LLUtils.ListNode mid =findMid(head);
        LLUtils.ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseLL(head2);

        while (head2 != null){
            if (head.val == head2.val){
                head = head.next;
                head2 = head2.next;
            }
            else
                return 0;
        }
        return 1;
    }

    public static LLUtils.ListNode reverseLL(LLUtils.ListNode head){
        if (head==null || head.next==null)
            return head;

        LLUtils.ListNode A = head;
        LLUtils.ListNode B = head.next;
        LLUtils.ListNode C = head.next.next;

        while (B != null){
            B.next = A;
            A = B;
            B = C;
            if (C!=null)
                C = C.next;
        }
        head.next = null;
        head = A;
        return head;
    }

    public static LLUtils.ListNode findMid(LLUtils.ListNode head){
        if (head==null || head.next==null)
            return head;
        LLUtils.ListNode fast = head;
        LLUtils.ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
