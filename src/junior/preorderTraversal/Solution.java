package junior.preorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/binary-tree-preorder-traversal/
* */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void  preorderTraversal(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        ls.add(root.val);
        preorderTraversal(root.left, ls);
        preorderTraversal(root.right, ls);
    }
}
