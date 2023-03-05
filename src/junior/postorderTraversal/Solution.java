package junior.postorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/binary-tree-preorder-traversal/
* */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root, res);
        return res;
    }
    private void  postorderTraversal(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        postorderTraversal(root.left, ls);
        postorderTraversal(root.right, ls);
        ls.add(root.val);
    }
}
