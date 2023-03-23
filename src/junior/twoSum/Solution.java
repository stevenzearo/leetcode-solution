package junior.twoSum;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int pre = nums[i];
            int ind = Arrays.binarySearch(nums, i + 1, nums.length, target - pre);
            if (ind > 0) return new int[]{i + 1, ind + 1};
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] res1 = solution.twoSum(nums1, 9);
        printResult(res1);

        int[] nums2 = new int[]{2, 3, 4};
        int[] res2 = solution.twoSum(nums2, 6);
        printResult(res2);

        int[] nums3 = new int[]{3, 3};
        int[] res3 = solution.twoSum(nums3, 6);
        printResult(res3);
    }

    private static void printResult(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}