package nowcoder.reverseBetween;

/**
 * @author Steve Zou
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int leftM = m - 1;
        int rightN = n - 1;

        // write code here
        if (head == null || head.next == null) return head;
        if (leftM == 1 && leftM == rightN) return head;

        int lnLength = 0;
        ListNode cur = head;
        while (cur != null) {
            lnLength++;
            cur = cur.next;
        }

        ListNode[] lns = new ListNode[lnLength];
        lns[0] = head;
        cur = head;
        int ind = 0;

        while (cur.next != null) {
            ind ++;
            lns[ind] = cur.next;
            cur = cur.next;
        }

        for (int i = 0; i < lnLength; i++) {
            lns[i].next = null;
        }

        int mid = (rightN - leftM) / 2;
        for (int i = 0; i <= mid; i++) {
            ListNode left = lns[leftM + i];
            ListNode right = lns[rightN - i];
            lns[rightN - i] = left;
            lns[leftM + i] = right;
        }

        for (int i = 0; i < lnLength - 1; i++) {
            lns[i].next = lns[i + 1];
        }
        return lns[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        // 1 -> 2 -> 3 -> 4


        ListNode ln = solution.reverseBetween(ln1, 2, 4);
        ListNode lnx;
    }
}
