package junior.longestCommonPrefix;

/**
 * @author Steve Zou
 */
public class JSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int minLenInd = 0;
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minLenInd = i;
            }
        }

        String commPrefix = strs[minLenInd];
        for (String curStr : strs) {
            while (!curStr.startsWith(commPrefix)) {
                commPrefix = commPrefix.substring(0, commPrefix.length() - 1);
            }
        }
        return commPrefix;
    }

    public static void main(String[] args) {
        JSolution solution = new JSolution();
        String[] strs = new String[]{"reflower", "flow", "flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
