package junior.romanToInt;

import java.util.Arrays;

/**
 * @author Steve Zou
 */
public class JSolution {
    char[] dict = new char[] {'C', 'D', 'I', 'L', 'M', 'V', 'X'};
    int[] dictVal = new int[] {100, 500, 1, 50, 1000, 5, 10};

    public int romanToInt(String s) {
        if (s.length() < 1) return 0;
        char[] chars = s.toCharArray();
        char preChar = chars[0];
        int preLevel = romanCharToInt(preChar);
        int curLevelSum = 0;
        int sum = 0;
        for (char aChar : chars) {
            int curLevel = romanCharToInt(aChar);
            if (preLevel == curLevel) {
                curLevelSum += curLevel;
            } else if (preLevel > curLevel) {
                sum += curLevelSum;
                curLevelSum = curLevel;
                preLevel = curLevel;
            } else {
                sum -= curLevelSum;
                curLevelSum = curLevel;
                preLevel = curLevel;
            }
        }
        sum += curLevelSum;
        return sum;
    }

    public int romanCharToInt(char c) {
        int ind = Arrays.binarySearch(dict, c);
        return dictVal[ind];
    }

    public static void main(String[] args) {
        JSolution solution = new JSolution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
