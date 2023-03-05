package junior.decompressRLElist;

/*
 *
 * https://leetcode.cn/problems/decompress-run-length-encoded-list/
 * */
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int pairLen = nums.length / 2;
        int[] freqs = new int[pairLen];
        int[] values = new int[pairLen];
        for (int i = 0; i < nums.length; i += 2) {
            freqs[i / 2] = nums[i];
            values[i / 2] = nums[i + 1];
        }
        int len = 0;
        for (int freq: freqs) {
            len += freq;
        }
        int[] orignalNums = new int[len];
        int cursor = 0;
        for (int i = 0; i < values.length; i++) {
            int num = values[i];
            int freq = freqs[i];
            for (int j = 0; j < freq; j++) {
                orignalNums[cursor] = num;
                cursor++;
            }
        }
        return orignalNums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = solution.decompressRLElist(new int[] {1, 2, 3, 4});
        for (int num: nums) {
            System.out.print(num + ", ");
        }
    }
}