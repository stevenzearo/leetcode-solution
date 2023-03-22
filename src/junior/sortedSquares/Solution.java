package junior.sortedSquares;

import java.util.Arrays;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/squares-of-a-sorted-array/
* */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int cur; int next;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                next = nums[j];
                if (cur > next) {
                    nums[j] = cur;
                    nums[i] = next;
                    cur = next;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = solution.sortedSquares(new int[]{-7,-3,2,3,11});
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
