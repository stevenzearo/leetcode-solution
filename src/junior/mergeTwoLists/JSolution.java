package junior.mergeTwoLists;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Steve Zou
 */
public class JSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode[] nodes = new ListNode[100];
        int len = appendNode(nodes, 0, list1);
        int total = appendNode(nodes, len, list2);
        Arrays.sort(nodes, Comparator.comparingInt((ListNode n) -> n == null ? Integer.MAX_VALUE : n.val));

        for (int i = 1; i < total; i++) {
            ListNode pre = nodes[i - 1];
            pre.next = nodes[i];
        }
        return nodes[0];
    }

    public int appendNode(ListNode[] ls, int ind, ListNode node) {
        while (node != null) {
            ls[ind] = node;
            ind++;
            node = node.next;
        }
        return ind;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        JSolution jSolution = new JSolution();
        ListNode listNode = jSolution.mergeTwoLists(node1, node4);
        ListNode n = listNode;
    }
}

