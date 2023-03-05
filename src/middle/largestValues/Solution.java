package middle.largestValues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                levelMax = Math.max(node.val, levelMax);
            }
            res.add(levelMax);
        }
        return res;
    }
}
