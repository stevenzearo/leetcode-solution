package nowcoder.vc1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Steve Zou
 */
/*
 *VC1 牛牛吃草
 * */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String lenStr = in.nextLine();
        int len = Integer.valueOf(lenStr);
        String weightStr = in.nextLine();
        String stepStr = in.nextLine();
        Integer[] weights = Arrays.stream(weightStr.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] steps = Arrays.stream(stepStr.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        int globalMaxWeight = 0;

        for (int i = 0; i < len; i++) {
            int curLoc = i;
            int totalWeight = weights[i];
            int curMaxWeight = totalWeight;
            int step = steps[curLoc];
            int n = 1;
            int start = i + step * n;
            while (i + step * n < len) {
                curLoc = i;
                totalWeight = 0;
                while (curLoc < len) {
                    totalWeight += weights[curLoc];
                    int nextStep = steps[curLoc];
                    curLoc += nextStep;
                }
                if (curMaxWeight < totalWeight) curMaxWeight = totalWeight;
                n++;
            }
            if (globalMaxWeight < curMaxWeight) globalMaxWeight = curMaxWeight;
        }
        System.out.println(globalMaxWeight);
    }
}


