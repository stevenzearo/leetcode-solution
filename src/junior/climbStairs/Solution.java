package junior.climbStairs;

/**
 * @author Steve Zou
 */

/*
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * */
public class Solution {
    public int climbStairs(int n) {
        // 1 -> 1, 2 -> 2, 3 -> 3 (1 * 3, 2+1， 1 + 2)
        int step0 = 1;
        int step1 = 2;
        if (n == 1) return step0;
        if (n == 2) return step1;
        int currentStep = 1;
        for (int i = 2; i < n; i++) {
            currentStep = step1 + step0;
            step0 = step1;
            step1 = currentStep;
        }
        return currentStep;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
        System.out.println(new Solution().climbStairs(5));
        System.out.println(new Solution().climbStairs(6));
        System.out.println(new Solution().climbStairs(7));
    }
}
