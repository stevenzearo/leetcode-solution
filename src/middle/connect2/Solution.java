package middle.connect2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Steve Zou
 */

/*
* https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
* */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            Node cur;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                pre = cur;
            }
        }
        return root;
    }
}
