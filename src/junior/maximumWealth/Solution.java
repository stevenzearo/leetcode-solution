package junior.maximumWealth;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/richest-customer-wealth/
 * */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum;
        int maxSum = 0;
        int[] nums;
        for (int[] account : accounts) {
            nums = account;
            sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumWealth(new int[][]{new int[]{1, 2, 3}, new int[]{3, 2, 1}});
        System.out.println(i);

    }
}
