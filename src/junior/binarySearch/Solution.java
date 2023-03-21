package junior.binarySearch;

/**
 * @author Steve Zou
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] > target || nums[r] < target) {
                return -1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] {-1}, -1));
        System.out.println(solution.search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(solution.search(new int[] {-1,0,3,5,9,12}, 2));
    }
}
