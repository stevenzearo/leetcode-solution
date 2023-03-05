package huawei.water;

import java.util.Scanner;

/**
 * @author Steve Zou
 */
public class Solution {
    public int exchangeWater(int n) {
        int count = 0;
        if (n < 3) return count;
        var next = n;
        while (next >= 3) {
            count += next / 3;
            next = next / 3 + next % 3;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a == 0) return;
            System.out.println(waterCount(a));
        }
    }

    private static int waterCount(int n) {
        int count = 0;
        if (n < 3) return count;
        int next = n;
        while (next >= 3) {
            count += next / 3;
            next = next / 3 + next % 3;
        }
        return count;
    }
}
