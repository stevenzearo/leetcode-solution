package junior.addBinary;

/**
 * @author Steve Zou
 */
/*
* https://leetcode.cn/problems/add-binary/
* */
public class Solution {
    public String addBinary(String a, String b) {
        if ("0".equals(a)) return b;
        if ("0".equals(b)) return a;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLen = aChars.length;
        int bLen = bChars.length;
        int len = Math.max(aLen, bLen);
        char[] res = new char[len + 1];
        boolean inc = false;
        int ind = 0;
        do {
            char aChar = ind < aLen ? aChars[aLen - 1 - ind] : '0';
            char bChar = ind < bLen ? bChars[bLen - 1 - ind] : '0';
            int aNum = toInt(aChar);
            int bNum = toInt(bChar);
            int newNum = inc ? aNum + bNum + 1 : aNum + bNum;
            if (newNum > 1) {
                inc = true;
                newNum = newNum % 2;
            } else {
                inc = false;
            }
            res[ind] = toChar(newNum);
            ind++;
        } while (inc || ind < len);

        char[] realRes = new char[ind];
        for (int i = 0; i < ind; i++) {
            realRes[realRes.length - 1 - i] = res[i];
        }
        return new String(realRes);
    }

    private int toInt(char a) {
        return a == '1' ? 1 : 0;
     }

     private char toChar(int num) {
        return num == 0 ? '0' : '1';
     }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1111", "1"));;
        System.out.println(solution.addBinary("1010", "1011"));;
        System.out.println(solution.addBinary("1111", "1111"));;
    }
}
