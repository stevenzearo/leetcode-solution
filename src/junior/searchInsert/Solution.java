package junior.searchInsert;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/search-insert-position/
 * */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        do {
            mid = (left + right) / 2;
            if (nums[left] > target) {
                return left;
            } else if (nums[right] < target) {
                return right + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        } while (left < mid || right > mid);
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
