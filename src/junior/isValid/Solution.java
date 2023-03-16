package junior.isValid;

import java.util.Stack;

/**
 * @author Steve Zou
 */
public class Solution {
    public boolean isValid(String s) {
        int preLen = s.length();
        while (!s.isEmpty()) {
            s = s.replace("()", "")
                .replace("[]", "")
                .replace("{}", "");
            if (s.length() == preLen) return false;
            preLen = s.length();
        }
        return true;
    }

    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid2("{}"));
        System.out.println(solution.isValid2("{[]}"));
        System.out.println(solution.isValid2("{[}]"));
        System.out.println(solution.isValid2("{[]}}"));
    }
}
