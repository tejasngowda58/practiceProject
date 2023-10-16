package practice.AdvancedDSA.LinkedList;

public class FindMiddleElement {
    public static void main(String[] args) {
        LLUtils utils = new LLUtils();
        LLUtils.ListNode head = null;
        head = utils.insert(head, 1);
        utils.insert(head, 2);
        utils.insert(head, 3);
        utils.insert(head, 4);
        utils.insert(head, 5);
        utils.insert(head, 6);
        System.out.println(solve(head));
    }

    public static int solve(LLUtils.ListNode A) {
        LLUtils.ListNode temp = A;
        int length = 0;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        if (length==1)
            return temp.val;

        int mid = length/2;
        temp = A;
        int count = 0;
        while (count<mid){
            count++;
            temp = temp.next;
        }
        return temp.val;
    }
}
