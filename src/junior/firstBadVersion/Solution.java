package junior.firstBadVersion;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/first-bad-version/submissions/
* */
public class Solution {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l / 2 + r / 2;
            if (l % 2 == 1 && r % 2 == 1) mid ++;

            if (isBadVersion(mid)) {
                r = mid - 1;
                if (!isBadVersion(r)) return mid;
            } else {
                l = mid + 1;
                if (isBadVersion(l)) return l;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.firstBadVersion(10));
        System.out.println(solution.firstBadVersion(2126753390));
    }
}
