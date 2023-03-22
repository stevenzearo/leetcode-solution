package junior.rotate;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/rotate-array
* */
public class Solution {
    public void rotate(int[] nums, int k) {
        int r = k % nums.length;
        if (r == 0) return;

        int[] newNums = new int[nums.length];
        if (r >= 0) System.arraycopy(nums, nums.length - r, newNums, 0, r);
        if (nums.length - r >= 0) System.arraycopy(nums, 0, newNums, r, nums.length - r);
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
