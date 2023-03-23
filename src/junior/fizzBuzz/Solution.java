package junior.fizzBuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve Zou
 */
/*
 * https://leetcode.cn/problems/fizz-buzz/
 * */
public class Solution {
    public List<String> fizzBuzz(int n) {
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                res[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                res[i - 1] = "Buzz";
            } else {
                res[i - 1] = i + "";
            }
        }
        return List.of(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.fizzBuzz(15);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}
