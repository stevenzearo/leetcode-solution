package middle.lengthOfLongestSubstring;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Steve Zou
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;


        HashSet<Character> set = new HashSet<>();
        int[] maxInd = new int[2];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                char[] subChars = new char[j + 1 - i];
                for (int k = i; k < j + 1; k++) {
                    set.add(chars[k]);
                }
                if (set.size() == j + 1 - i) {
                    int curLen = maxInd[1] - maxInd[0];
                    if (curLen < j + 1 - i) {
                        maxInd[0] = i;
                        maxInd[1] = j;
                    }
                }
                set.clear();
            }
        }
        return maxInd[1] - maxInd[0] + 1;
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
        int length = solution.lengthOfLongestSubstring2("abcabcbb");
        System.out.println(length);
    }
}
