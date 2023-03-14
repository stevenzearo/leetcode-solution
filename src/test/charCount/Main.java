package test.charCount;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Steve Zou
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            HashSet<Character> charSet = new HashSet<>();
            for(char c: str.toCharArray()) {
                charSet.add(c);
            }
            System.out.println(charSet.size());
        }
    }
}
