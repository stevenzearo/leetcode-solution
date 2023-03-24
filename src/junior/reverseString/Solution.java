package junior.reverseString;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/reverse-string/
* */
public class Solution {
    public void reverseString(char[] s) {
        if (s.length == 1) return;
        for (int i = 0; i < s.length / 2; i++) {
            char head = s[i];
            char tail = s[s.length - 1 - i];
            if (head != tail) {
                s[i] = tail;
                s[s.length - 1 - i] = head;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(chars);
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
    }
}
