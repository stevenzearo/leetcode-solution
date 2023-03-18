package middle.checkPalindromeFormation;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 * res: 超出时间限制
 * */
public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        if (len == 1) return true;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        if (checkPalindromeFormation(aChars) || checkPalindromeFormation(bChars)) return true;
        if (aChars[0] != bChars[len - 1] && aChars[len - 1] != bChars[0]) return false;
        for (int i = 1; i < len - 1; i++) {
            String aPre = a.substring(0, i);
            String aSub = a.substring(i);
            String bPre = b.substring(0, i);
            String bSub = b.substring(i);
            if (checkPalindromeFormation((aPre + bSub).toCharArray()) || checkPalindromeFormation((bPre + aSub).toCharArray()))
                return true;
        }
        return false;
    }

    private boolean checkPalindromeFormation(char[] chars) {
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char head = chars[i];
            char tail = chars[len - 1 - i];
            if (head != tail) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPalindromeFormation("x", "y"));
        System.out.println(solution.checkPalindromeFormation("abdef", "fecab"));
        System.out.println(solution.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(solution.checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));

        System.out.println(solution.checkPalindromeFormation("ulacfd", "jizaau"));
        System.out.println(solution.checkPalindromeFormation("abccef", "cgdhga"));
    }
}
