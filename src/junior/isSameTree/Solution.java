package junior.isSameTree;

/**
 * @author Steve Zou
 */

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/">isSameTree</a>
 */
public class Solution {
    public boolean  isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
