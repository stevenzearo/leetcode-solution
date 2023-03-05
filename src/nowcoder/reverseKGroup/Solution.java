package nowcoder.reverseKGroup;

/**
 * @author Steve Zou
 */
public class Solution {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            length++;
        }

        ListNode[] lns = new ListNode[length];
        lns[0] = head;

        int ind = 0;
        ListNode ln = head;
        while (ln.next != null) {
            lns[ind + 1] = ln.next;
            ln = ln.next;
            ind++;
        }

        // reset node
        for (int i = 0; i < length; i++) {
            lns[i].next = null;
        }

        int groups = length / k;
        int mid = k / 2;
        for (int i = 0; i < groups; i++) {
            for (int j = 0; j < mid; j++) {
                int leftInd = i * k + j;
                int rightInd = (i + 1) * k - j - 1;
                ListNode left = lns[leftInd];
                ListNode right = lns[rightInd];
                lns[leftInd] = right;
                lns[rightInd] = left;
            }
        }
        for (int i = 0; i < length - 1; i++) {
            lns[i].next = lns[i + 1];
        }
        return lns[0];
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        Solution solution = new Solution();
        solution.reverseKGroup(ln1, 2);
    }
}
