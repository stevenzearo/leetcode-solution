package middle.longestSubstring;

import java.util.HashMap;

/**
 * @author Steve Zou
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int maxSubCharLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                int minFreq = calculateMinFreq(s.substring(j, i+1).toCharArray(), j, i);
                int charLen = i - j + 1;
                if (minFreq >= k && maxSubCharLength < charLen) {
                    maxSubCharLength = charLen;
                }
            }
        }
        return maxSubCharLength;
    }
    private int calculateMinFreq2(char[] chars) {
        int[] charFreqs = calculateCharFreq2(chars);
        int minFreq = chars.length;
        for (int freq : charFreqs) {
            if (freq != 0 && freq < minFreq) minFreq = freq;
        }
        return minFreq;
    }

    private static int[] calculateCharFreq2(char[] chars) {
        int[] charFreqs = new int[26];
        for (char c: chars) {
            charFreqs[c - 'a']++;
        }
        return charFreqs;
    }

    private int calculateMinFreq(char[] chars, int j, int i) {
        int freqLen = i - j + 1;
        if (freqLen < 1) return 1;

        HashMap<Character, Integer> charFreq = calculateCharFreq(chars);
        int minFreq = freqLen;
        for (int freq : charFreq.values()) {
            if (freq < minFreq) minFreq = freq;
        }
        return minFreq;
    }

    private static HashMap<Character, Integer> calculateCharFreq(char[] chars) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char curChar : chars) {
            Integer newVal = charFreq.computeIfPresent(curChar, (k, v) -> v++);
            if (newVal != null) {
                charFreq.put(curChar, newVal + 1);
            } else {
                charFreq.put(curChar, 1);
            }
        }
        return charFreq;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("aaabb", 3));
        ;
        System.out.println(solution.longestSubstring("ababbc", 2));
        ;
        System.out.println(solution.longestSubstring("aabbbc", 3));
        ;
        System.out.println(solution.longestSubstring("aabbbc", 2));
        ;
    }
}
