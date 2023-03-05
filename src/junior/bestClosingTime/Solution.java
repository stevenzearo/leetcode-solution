package junior.bestClosingTime;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/minimum-penalty-for-a-shop/
 * */
public class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int[] costs = new int[len + 1];
        char[] chars = customers.toCharArray();
        if (len == 1) return chars[0] == 'Y' ? 1 : 0;

        int minCost = len;
        int minCostInd = 0;
        for (int i = 0; i <= chars.length; i++) {
            int cost = 0;
            for (int j = 0; j < i; j++) {
                if (chars[j] == 'N') {
                    cost ++;
                }
            }
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == 'Y') {
                    cost ++;
                }
            }
            costs[i] = cost;
            if (cost < minCost) {
                minCost = cost;
                minCostInd = i;
            }
        }
        return minCostInd;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYNY"));;
        System.out.println(solution.bestClosingTime("NNNNN"));;
        System.out.println(solution.bestClosingTime("YYYY"));;
    }
}
