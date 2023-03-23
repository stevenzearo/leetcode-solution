package junior.moveZeroes;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/move-zeroes
* */
public class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        int end = nums.length;
        while (ind < end) {
            if (nums[ind] != 0) {
                ind++;
            } else {
                int z = nums[ind];
                for (int i = ind; i < end - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[end - 1] = z;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
