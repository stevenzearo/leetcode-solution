package junior.inorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/binary-tree-preorder-traversal/
* */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }
    private void  inorderTraversal(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        inorderTraversal(root.left, ls);
        ls.add(root.val);
        inorderTraversal(root.right, ls);
    }
}
