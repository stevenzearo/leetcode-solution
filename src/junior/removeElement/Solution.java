package junior.removeElement;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/remove-element/
 * */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int startInd = 0;
        while (startInd < len) {
            if (nums[startInd] == val) {
                for (int i = startInd; i < len - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                startInd--;
                len--;
            }
            startInd++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 3};
        int i = solution.removeElement(nums, 3);
        System.out.println(i);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

