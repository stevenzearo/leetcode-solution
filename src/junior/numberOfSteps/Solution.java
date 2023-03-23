package junior.numberOfSteps;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/
 * */
public class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int c = 0;
        int n = num;
        while (n > 0) {
            n = n % 2 == 1 ? n - 1 : n >> 1;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
    }
}
