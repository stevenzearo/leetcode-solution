package junior.averageOfLevels;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 * */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double levelSum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                levelSum += node.val;
            }
            res.add(levelSum / (size + 0d));
        }
        return res;
    }
}
