package junior.maxArea;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/container-with-most-water/
* */
public class Solution {
    public int maxArea(int[] height) {
        int maxQ = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                int l = j - i;
                int h = Math.min(left, right);
                int quantity = l * h;
                maxQ = Math.max(quantity, maxQ);
            }
        }
        return maxQ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));;
        System.out.println(solution.maxArea(new int[] {1,1}));;
    }
}
