package junior.mySqrt;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/sqrtx/
 * */
public class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt2(int x) {
        if (x <= 1) return x;
        int lower = getLower(x);
        long res = lower;
        for (long i = lower >> 1; i <= lower; i++) {
            if (i * i <= x) {
                res = i;
            } else {
                break;
            }
        }
        return (int) res;
    }

    private int getLower(int x) {
        long lower = 1;
        do {
            lower = lower << 1;
        } while (lower * lower < x);
        return (int) lower;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4) + " " + solution.mySqrt2(4));
        System.out.println(solution.mySqrt(8) + " " + solution.mySqrt2(8));
        System.out.println(solution.mySqrt(9) + " " + solution.mySqrt2(9));
        System.out.println(solution.mySqrt(10) + " " + solution.mySqrt2(10));
        System.out.println(solution.mySqrt(2147395599) + " " + solution.mySqrt2(2147395599));
        System.out.println(solution.mySqrt(Integer.MAX_VALUE) + " " + solution.mySqrt2(Integer.MAX_VALUE));
    }

}
