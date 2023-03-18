package junior.removeDuplicates;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * */
public class Solution {
    /*
     * @return: length of nums removed  duplicates
     * */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            int preVal = nums[i - 1];
            if (preVal == num) {
                for (int j = i; j < len; j++) {
                    nums[j - 1] = nums[j];
                }
                len--;
                i--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = solution.removeDuplicates(nums);
        System.out.println(len);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
