package practice.basic.sorting;

import junior.sortedSquares.Solution;

/**
 * @author Steve Zou
 */
public class SortingDemo {
    public void bubbleSorting(int[] nums) {
        int a;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    a = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = a;
                }
            }
        }
    }


    public static void main(String[] args) {
        SortingDemo demo = new SortingDemo();
        int[] nums = {3, 4, 2, 1, 6, 5, 5, 1, 8};
        demo.bubbleSorting(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
