package middle.zigzagLevelOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] lse = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                lse[i] = node.val;
            }

            if (reverse) {
                for (int i = 0; i < lse.length / 2; i++) {
                    Integer left = lse[i];
                    Integer right = lse[lse.length - 1 - i];
                    lse[i] = right;
                    lse[lse.length - 1 - i] = left;
                }
            }
            List<Integer> ts = Arrays.asList(lse);
            res.add(ts);
            reverse = !reverse;
        }
        return res;
    }
}
