package middle.myAtoi;

/*
* Leetcode Reference: https://leetcode.cn/problems/string-to-integer-atoi/description/
* */
public class JSolution {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length < 1) {
            return 0;
        }
        if ((chars[0] < '0' || chars[0] > '9') && chars[0] != '-' && chars[0] != '+') {
            return 0;
        }
        if (chars.length == 1) {
            return chars[0] == '-' || chars[0] == '+' ? 0 : Integer.parseInt(new String(chars));
        }

        boolean skipZero = true;

        StringBuilder zerosStrBuilder = new StringBuilder();
        StringBuilder numStrBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if (skipZero && curr == '0') {
                zerosStrBuilder.append(curr);
                continue;
            }
            skipZero = false;
            if (curr < '0' || curr > '9') {
                break;
            }
            numStrBuilder.append(curr);
        }
        if (chars[0] != '-' && chars[0] != '+' && chars[0] != '0') {
            numStrBuilder = zerosStrBuilder.append(numStrBuilder);
        }
        if (numStrBuilder.length() == 0) {
            return chars[0] == '-' || chars[0] == '+' ? 0 : Integer.parseInt(String.valueOf(chars[0]));
        }
        boolean positive = chars[0] != '-';

        char[] prefix = {chars[0]};
        String numStr = new String(prefix) + numStrBuilder;

        if (positive && numStr.length() > String.valueOf(Integer.MAX_VALUE).length() + 1) {
            return Integer.MAX_VALUE;
        }
        if (!positive && numStr.length() > String.valueOf(Integer.MIN_VALUE).length() + 1) {
            return Integer.MIN_VALUE;
        }

        long l = Long.parseLong(numStr);
        if (l >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        JSolution jSolution = new JSolution();
        int i = jSolution.myAtoi("4193 with words");
        System.out.println(i == 4193);

        i = jSolution.myAtoi("   -42");
        System.out.println(i == -42);

        i = jSolution.myAtoi("42");
        System.out.println(i == 42);

        i = jSolution.myAtoi("+55");
        System.out.println(i == 55);

        i = jSolution.myAtoi("words and 987");
        System.out.println(i == 0);

        i = jSolution.myAtoi("3.14159");
        System.out.println(i == 3);

        i = jSolution.myAtoi("+-12");
        System.out.println(i == 0);

        i = jSolution.myAtoi("00000-42a1234");
        System.out.println(i == 0);

        i = jSolution.myAtoi("  0000000000012345678");
        System.out.println(i == 12345678);

        i = jSolution.myAtoi("  010");
        System.out.println(i == 10);

        i = jSolution.myAtoi("  -010");
        System.out.println(i == -10);

        i = jSolution.myAtoi("  -0000000000000000000000000000000000000000010");
        System.out.println(i == -10);

        i = jSolution.myAtoi("2147483646");
        System.out.println(i == 2147483646);

        i = jSolution.myAtoi("-2147483647");
        System.out.println(i == -2147483647);

        i = jSolution.myAtoi("2147483648");
        System.out.println(i == 2147483647);

        i = jSolution.myAtoi("20000000000000000000");
        System.out.println(i == 2147483647);

        i = jSolution.myAtoi(" 0000000000000000000  ");
        System.out.println(i == 0);

        i = jSolution.myAtoi("       1056706k5060");
        System.out.println(i == 1056706);
    }
}

/*
*
*
*
* "C:\Program Files\Java\jdk-21\bin\java.exe" -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:5952,suspend=y,server=n -javaagent:C:\Users\steve\AppData\Local\JetBrains\IntelliJIdea2023.1\captureAgent\debugger-agent.jar -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\steve\IdeaProjects\leetcode-solution\out\production\leetcode-solution;C:\scala\lib\scala-library.jar;C:\scala\lib\scala-reflect.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2023.1.5\lib\idea_rt.jar" middle.myAtoi.JSolution
Connected to the target VM, address: '127.0.0.1:5952', transport: 'socket'
------------
4193
------------
-42
------------
42
------------
55
------------
0
------------
3
------------
0
------------
0
------------
12345678
------------
10
------------
-10
------------
-10
------------
2147483646
------------
-2147483647
------------
2147483647
------------
2147483647
------------
0
------------
1056706
Disconnected from the target VM, address: '127.0.0.1:5952', transport: 'socket'

Process finished with exit code 0

*
* */