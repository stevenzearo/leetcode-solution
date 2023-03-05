package junior.deleteDuplicates;

import java.util.List;

/**
 * @author Steve Zou
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cursor = head;
        do {
            if (cursor.next != null && cursor.val == cursor.next.val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        } while (cursor != null);
        return head;
    }

    public static void main(String[] args) {
        ListNode nLast = new ListNode(3, null);
        ListNode nLast1 = new ListNode(3, nLast);
        ListNode nLast2 = new ListNode(2, nLast1);
        ListNode nLast3 = new ListNode(1, nLast2);
        ListNode nLast4 = new ListNode(1, nLast3);

        new Solution().deleteDuplicates(nLast4); // 1 -> 2 -> 3

        var n = nLast2.next;

        ListNode nLasta = new ListNode(1, null);
        ListNode nLastb = new ListNode(1, nLasta);
        ListNode nLastc = new ListNode(1, nLastb);
        new Solution().deleteDuplicates(nLastc);
        var m = nLastc; // 1 -> null
    }
}
