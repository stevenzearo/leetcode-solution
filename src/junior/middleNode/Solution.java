package junior.middleNode;

import common.ListNode;

/**
 * @author Steve Zou
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        ListNode midCur = head;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            midCur = midCur.next;
        }
        if (cur.next != null) midCur = midCur.next;
        return midCur;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode cur = head;
        int count = 0;
        do {
            count += 2;

            cur = cur.next;
        } while (cur != null);

        int mid = count / 2;
        count = 0;
        cur = head;
        do {
            if (count == mid) return cur;
            count++;
            cur = cur.next;
        } while (cur != null);
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Solution solution = new Solution();
        ListNode listNode = solution.middleNode(n1);
        ListNode ln = listNode;
    }
}
