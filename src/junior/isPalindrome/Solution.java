package junior.isPalindrome;

/**
 * @author Steve Zou
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = x + "";
        char[] chars = s.toCharArray();
        int mid = chars.length / 2;
        for (int i = 0; i <= mid; i++) {
            char head = chars[i];
            char tail = chars[chars.length - 1 - i];
            if (head != tail) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPalindrome(1);
        System.out.println(res);
    }
}
