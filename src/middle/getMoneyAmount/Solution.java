package middle.getMoneyAmount;

import java.util.Arrays;

/**
 * @author Steve Zou
 */

/*
* 我们正在玩一个猜数游戏，游戏规则如下：
* 我从 1 到 n 之间选择一个数字。
* 你来猜我选了哪个数字。
* 如果你猜到正确的数字，就会 赢得游戏 。
* 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
* 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
* 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
* */
public class Solution {
    public int getMoneyAmount(int n) {
        int[] amountMaxes = new int[n];
        for (int i = 1; i <= n; i++) {
            amountMaxes[i - 1] = amountMax(i);
        }
        // todo
        return Arrays.stream(amountMaxes).min().getAsInt();
    }

    private int amountMax(int n) {
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) {
           int a = binarySearch(nums, nums[i]);
           amounts[i] = a;
        }
        return Arrays.stream(amounts).max().orElse(0);
    }

    public int binarySearch(int[] nums, int target) {
        int amount = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return amount;
            } else if (nums[mid] > target) {
                amount += nums[mid];
                right = mid - 1;
            } else if (nums[mid] < target) {
                amount += nums[left];
                left = mid + 1;
            }
        }
        return 0;
    }

    public void testBinarySearch() {
        int[] nums = new int[]{2, 3, 5, 6, 8};
        Solution solution = new Solution();

        System.out.println(solution.binarySearch(nums, 3));
        System.out.println(solution.binarySearch(nums, 8));
        System.out.println(solution.binarySearch(nums, 0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMoneyAmount(10));
        System.out.println(solution.getMoneyAmount(16));
    }
}
