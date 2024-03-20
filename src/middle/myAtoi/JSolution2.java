package middle.myAtoi;

import java.util.LinkedList;

/*
 * Leetcode Reference: https://leetcode.cn/problems/string-to-integer-atoi/description/
 * */
public class JSolution2 {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length < 1) {
            return 0;
        }
        if ((chars[0] < '0' || chars[0] > '9') && chars[0] != '-' && chars[0] != '+') {
            return 0;
        }
        if (chars.length == 1) {
            return chars[0] == '-' || chars[0] == '+' ? 0 : Integer.parseInt(new String(chars));
        }

        LinkedList<Character> nums = new LinkedList<>();
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if (curr < '0' || curr > '9') {
                break;
            }
            nums.addLast(curr);
        }

        if (nums.size() == 0) {
            return chars[0] == '-' || chars[0] == '+' ? 0 : Integer.parseInt(String.valueOf(chars[0]));
        }

        if (chars[0] != '-' && chars[0] != '+') {
            nums.addFirst(chars[0]);
        }
        while (nums.peek() != null && nums.peek().equals('0')) {
            nums.poll();
        }

        if (nums.size() == 0) {
            return 0;
        }

        if (chars[0] == '-') {
            nums.addFirst(chars[0]);
        }

        boolean positive = chars[0] != '-';

        char[] numChars = new char[nums.size()];
        int ind = 0;
        while (nums.peek() != null) {
            numChars[ind] = nums.poll();
            ind++;
        }
        String numStr = new String(numChars);
        if (positive && numStr.length() > String.valueOf(Integer.MAX_VALUE).length() + 1) {
            return Integer.MAX_VALUE;
        }
        if (!positive && numStr.length() > String.valueOf(Integer.MIN_VALUE).length() + 1) {
            return Integer.MIN_VALUE;
        }

        long l = Long.parseLong(numStr);
        if (l >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        JSolution jSolution = new JSolution();
        int i = jSolution.myAtoi("4193 with words");
        System.out.println(i == 4193);

        i = jSolution.myAtoi("   -42");
        System.out.println(i == -42);

        i = jSolution.myAtoi("42");
        System.out.println(i == 42);

        i = jSolution.myAtoi("+55");
        System.out.println(i == 55);

        i = jSolution.myAtoi("words and 987");
        System.out.println(i == 0);

        i = jSolution.myAtoi("3.14159");
        System.out.println(i == 3);

        i = jSolution.myAtoi("+-12");
        System.out.println(i == 0);

        i = jSolution.myAtoi("00000-42a1234");
        System.out.println(i == 0);

        i = jSolution.myAtoi("  0000000000012345678");
        System.out.println(i == 12345678);

        i = jSolution.myAtoi("  010");
        System.out.println(i == 10);

        i = jSolution.myAtoi("  -010");
        System.out.println(i == -10);

        i = jSolution.myAtoi("  -0000000000000000000000000000000000000000010");
        System.out.println(i == -10);

        i = jSolution.myAtoi("2147483646");
        System.out.println(i == 2147483646);

        i = jSolution.myAtoi("-2147483647");
        System.out.println(i == -2147483647);

        i = jSolution.myAtoi("2147483648");
        System.out.println(i == 2147483647);

        i = jSolution.myAtoi("20000000000000000000");
        System.out.println(i == 2147483647);

        i = jSolution.myAtoi(" 0000000000000000000  ");
        System.out.println(i == 0);

        i = jSolution.myAtoi("       1056706k5060");
        System.out.println(i == 1056706);
    }
}