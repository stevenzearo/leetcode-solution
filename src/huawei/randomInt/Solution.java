package huawei.randomInt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Steve Zou
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int numCount = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numCount; i++) { // 注意 while 处理多个 case
            nums.add(in.nextInt());
        }
        nums.stream().distinct().sorted().forEach(System.out::println);
    }
}