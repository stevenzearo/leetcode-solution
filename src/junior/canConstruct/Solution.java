package junior.canConstruct;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/ransom-note/
 * */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqX = new int[26];
        int[] freqY = new int[26];
        setCharFreq(ransomNote.toCharArray(), freqX);
        setCharFreq(magazine.toCharArray(), freqY);
        for (int i = 0; i < freqX.length; i++) {
            if (freqX[i] > freqY[i]) return false;
        }
        return true;
    }

    private static void setCharFreq(char[] chars, int[] freqs) {
        for (char c : chars) {
            freqs[c - 'a']++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aa", "aab"));
        ;
    }
}
