package middle.levelOrderBottom;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> linkedRes = new LinkedList<>();
        if (root == null) return linkedRes;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] lse = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                lse[i] = node.val;
            }
            linkedRes.push(Arrays.asList(lse));
        }
        return linkedRes;
    }
}
