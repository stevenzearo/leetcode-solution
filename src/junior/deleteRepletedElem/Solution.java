package junior.deleteRepletedElem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Steve Zou
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            set.add(num);
        }
        Integer[] res = set.toArray(Integer[]::new);
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
        return nums.length;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test1();
        solution.test2();
        solution.test3();
    }

    public void test1() {
        int[] nums = new int[]{1, 1, 2}; // 输入数组
        int[] expectedNums = new int[]{1, 2}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public void test2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 输入数组
        int[] expectedNums = new int[]{0, 1, 2, 3, 4}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }


    public void test3() {
        int[] nums = new int[]{1,1,2}; // 输入数组
        int[] expectedNums = new int[]{1, 2}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
