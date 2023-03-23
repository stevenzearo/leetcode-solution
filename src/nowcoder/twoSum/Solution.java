package nowcoder.twoSum;

/**
 * @author Steve Zou
 */
/*
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 * 数据范围：2≤len(numbers)≤1052≤len(numbers)≤105，−10≤numbersi≤109−10≤numbersi​≤109，0≤target≤1090≤target≤109
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 * */
public class Solution {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                if (a + b == target) return new int[] {i + 1, j + 1};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{3, 2, 4}, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
