package middle.lengthOfLongestSubstring;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/submissions/
/**
 * @author Steve Zou
 */
public class Solution {
    /*
    * result: 超出时间限制
    * */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;

        int maxCount = 0;
        Set<Character> characterSet = new LinkedHashSet<>();
        for (int i = 0; i < chars.length; i++) {
            characterSet.clear();
            for (int j = i; j < chars.length; j++) {
                if (characterSet.contains(chars[j])) {
                    maxCount = Math.max(characterSet.size(), maxCount);
                    characterSet.clear();
                    characterSet.add(chars[j]);
                } else {
                    characterSet.add(chars[j]);
                }
            }
            maxCount = Math.max(characterSet.size(), maxCount);
        }
        return Math.max(characterSet.size(), maxCount);
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;
        int maxLen = 1;
        for (int i = 0; i < chars.length; i++) {

            for (int j = i; j < chars.length; j++) {
                char[] subChars = new char[j - i + 1];
                for (int k = i; k < j + 1; k++) {
                    subChars[k - i] = chars[k];
                }
                boolean repeat = false;
                for (int k = 0; k < subChars.length - 1; k++) {
                    char c = subChars[k];
                    for (int l = k + 1; l < subChars.length; l++) {
                        if (Arrays.binarySearch(subChars, l, subChars.length, c) >= 0) {
                            repeat = true;
                            break;
                        }
                    }
                }
                if (repeat) break;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int length = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length == 3);

        length = solution.lengthOfLongestSubstring("bbbb");
        System.out.println(length == 1);

        length = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(length == 3);


        length = solution.lengthOfLongestSubstring("aab");
        System.out.println(length == 2);

        length = solution.lengthOfLongestSubstring("aabbcd");
        System.out.println(length == 3);

        length = solution.lengthOfLongestSubstring("dvdf");
        System.out.println(length == 3);
    }
}
