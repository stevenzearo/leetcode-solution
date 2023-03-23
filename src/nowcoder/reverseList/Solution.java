package nowcoder.reverseList;

import common.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
 *
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * 数据范围： 0≤n≤10000≤n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * 如当输入链表{1,2,3}时，经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 *
 * */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        List<ListNode> nums = new ArrayList<>();
        nums.add(cur);
        while (cur.next != null) {
            nums.add(cur.next);
            cur = cur.next;
        }
        if (nums.size() <= 1) return head;
        for (int i = 1; i < nums.size(); i++) {
            ListNode preNode = nums.get(i - 1);
            if (i == 1) preNode.next = null;
            ListNode curNode = nums.get(i);
            curNode.next = preNode;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;
        s.reverseList(ln1);
        ListNode next = ln1.next;
    }
}
