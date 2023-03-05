package middle.lengthOfLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Steve Zou
 */
/*
* 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
* 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
* */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] increasingLengths = new int[nums.length];
        Arrays.fill(increasingLengths, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    increasingLengths[i] = Math.max(increasingLengths[i], increasingLengths[j] + 1);
                }
            }
        }
        int maxLength = increasingLengths[0];
        for (int curVal: increasingLengths) {
            if (curVal > maxLength) maxLength = curVal;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(solution.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(solution.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
