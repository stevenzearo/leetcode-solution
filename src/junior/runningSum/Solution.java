package junior.runningSum;

/**
 * @author Steve Zou
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sum = solution.runningSum(new int[]{1, 2, 3, 4});
        for (int i : sum) {
            System.out.print(i + " ");
        }
    }
}
