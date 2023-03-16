package junior.reverse;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/reverse-integer/
* */
public class Solution {
    public int reverse(int x) {
        String s = Integer.toString(x);
        boolean isPositive = x >= 0;
        if (!isPositive) s = s.substring(1);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            char tail = chars[len - 1 -i];
            char head = chars[i];
            chars[len - 1 -i] = head;
            chars[i] = tail;
        }
        long reversed = Long.parseLong(String.copyValueOf(chars));
        reversed = isPositive ? reversed : -reversed;
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int) reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(Integer.MIN_VALUE));
    }
}
