package middle.addTwoNumbers;

import common.ListNode;

/**
 * @author Steve Zou
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] nums = new int[100];
        int maxLen = 0;
        int ind = 0;
        ListNode cur = l1;
        do {
            nums[ind] = cur.val;
            ind++;
            cur = cur.next;
        } while (cur != null);
        maxLen = ind;

        ind = 0;
        cur = l2;
        boolean inc = false;
        do {
            int a = nums[ind];
            int b = cur != null ? cur.val : 0;
            int sum = a + b;
            if (inc) sum++;
            int curVal = sum % 10;
            nums[ind] = curVal;
            inc = sum >= 10;
            ind++;
            cur = cur != null ? cur.next : null;
        } while (cur != null || inc);
        maxLen = Math.max(ind, maxLen);

        ListNode[] nodes = new ListNode[maxLen];
        for (int i = 0; i < maxLen; i++) {
            nodes[i] = new ListNode(nums[i]);
        }
        if (nodes.length == 1) return nodes[0];
        for (int i = 0; i < nodes.length - 1; i++) {
            ListNode curNode = nodes[i];
            curNode.next = nodes[i + 1];
        }
        return nodes[0];
    }

    public static void printNodes(ListNode node) {
        ListNode cur = node;
        do {
            System.out.print(cur.val);
            System.out.print(" -> ");
            cur = cur.next;
        } while (cur != null);
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n11 = new ListNode(9);
        ListNode n12 = new ListNode(9);
        ListNode n13 = new ListNode(9);
        ListNode n14 = new ListNode(9);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        ListNode n21 = new ListNode(9);
        ListNode n22 = new ListNode(9);
//        ListNode n23 = new ListNode(4);
        n21.next = n22;
//        n22.next = n23;

        ListNode res1 = solution.addTwoNumbers(n11, n21);
        printNodes(res1);

    }
}
