package junior.descarray;

/**
 * @author steve
 */

/*
* 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
* */
public class JSolution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) return true;

        int[] subNumbs = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            boolean removalInc = true;
            System.arraycopy(nums, 0, subNumbs, 0, i);
            if (nums.length - (i + 1) >= 0) System.arraycopy(nums, i + 1, subNumbs, i + 1 - 1, nums.length - (i + 1));
            for (int z = 1; z < subNumbs.length; z++) {
                int pre = subNumbs[z - 1];
                int cur = subNumbs[z];
                if (pre > cur) {
                    removalInc = false;
                    break;
                }
            }
            if (removalInc) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        JSolution solution = new JSolution();
        // min -> max
        System.out.println(solution.checkPossibility(new int[]{-1, 4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{1, 3, 2}));
        System.out.println(solution.checkPossibility(new int[]{2, 3, 3, 2, 1, 0}));
        System.out.println(solution.checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(solution.checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(solution.checkPossibility(new int[]{1,5,4,6,7,10,8,9}));
        System.out.println(solution.checkPossibility(new int[]{12,8,15,11,13,14}));
        System.out.println(solution.checkPossibility(new int[]{4, 1, 3, 2, 5}));
    }
}
