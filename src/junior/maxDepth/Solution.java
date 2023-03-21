package junior.maxDepth;

/**
 * @author Steve Zou
 */

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">maxDepth</a>
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int level) {
        if (root == null) return level;
        int newLevel = level + 1;
        int leftDepth = newLevel;
        int rightDepth = newLevel;
        if (root.left != null) {
            leftDepth = maxDepth(root.left, newLevel);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right, newLevel);
        }
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n2.right = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.left = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(n1));
    }
}
