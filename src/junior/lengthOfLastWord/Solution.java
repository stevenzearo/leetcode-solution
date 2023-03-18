package junior.lengthOfLastWord;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/length-of-last-word/
 * */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split("\\s+");
        return strings[strings.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        char[] chars = s.trim().toCharArray();
        int len = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                len++;
            } else {
                return len;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord2("Hello World"));
        System.out.println(solution.lengthOfLastWord2("   fly me   to   the moon  "));
        System.out.println(solution.lengthOfLastWord2("luffy is still joyboy"));
        System.out.println(solution.lengthOfLastWord2("   cCGiKdpcAjnbQbewGXqQDKuuwcg"));
    }
}
