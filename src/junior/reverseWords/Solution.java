package junior.reverseWords;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 * */
public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            int end = i - 1;
            if (chars[i] == ' ' && i < chars.length - 1) {
                reverseWord(chars, start, end);
                start = i + 1;
            } else if (i == chars.length - 1) {
                reverseWord(chars, start, chars.length - 1);
            }
        }
        return new String(chars);
    }

    private void reverseWord(char[] words, int start, int end) {
        int len = end - start;
        if (len < 1) return;
        for (int i = 0; i <= len / 2; i++) {
            char head = words[start + i];
            char tail = words[end - i];
            if (head != tail) {
                words[start + i] = tail;
                words[end - i] = head;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("i like me"));
    }

}
