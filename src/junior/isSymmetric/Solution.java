package junior.isSymmetric;

/**
 * @author Steve Zou
 */

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">isSymmetric</a>
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(1);
        n5.left = n4;
        n4.right = n2;

        n5.right = n3;
        n3.right = n1;

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(n5));
    }
}
