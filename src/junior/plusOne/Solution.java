package junior.plusOne;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/plus-one/
 * */
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean inc = false;
        int i = digits.length - 1;
        do {
            int num = digits[i];
            int newNum = num;
            if (i == digits.length - 1) {
                newNum = num + 1;
            }
            if (inc) {
                newNum++;
            }

            if (newNum >= 10) {
                digits[i] = newNum % 10;
                inc = true;
            } else {
                digits[i] = newNum;
                inc = false;
            }
            i--;
        } while (i >= 0);

        if (inc) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printNums(solution.plusOne(new int[]{1, 2, 3}));
        printNums(solution.plusOne(new int[]{4, 3, 2, 1}));
        printNums(solution.plusOne(new int[]{9, 9}));
        printNums(solution.plusOne(new int[]{0}));
    }

    public static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }
}
