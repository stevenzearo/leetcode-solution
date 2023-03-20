package junior.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Steve Zou
 */

/*
 * https://leetcode.cn/problems/merge-sorted-array/
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var allNums = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < m; i++) {
            allNums.add(nums1[i]);
        }
        var sortedNums = allNums.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedNums.size(); i++) {
            nums1[i] = sortedNums.get(i);
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int newLen = m;
        int indX = 0;
        for (int k : nums2) {
            if (newLen >= m + n) return;
            indX = binarySearch(nums1, indX, newLen - 1, k);
            newLen++;
            int preVal = nums1[indX];
            for (int j = indX + 1; j < newLen; j++) {
                int curVal = nums1[j];
                nums1[j] = preVal;
                preVal = curVal;
            }
            nums1[indX] = k;
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] > target) {
                return l;
            } else if (nums[r] <= target) {
                return r + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        Solution solution = new Solution();
        solution.merge2(nums1, 0, nums2, 1);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
