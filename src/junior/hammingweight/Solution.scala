package junior.hammingweight

/**
 * @author steve
 */

/*
* 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
* */

object Solution {

    // you need treat n as an unsigned value
    def hammingWeight(n: Int): Int = {
        Integer.bitCount(n)
    }

    def main(args: Array[String]): Unit = {
        // 1 / 2 = 0 ... 1
        // 3 / 2 = 1 ... 1
        println(hammingWeight(1))
        println(hammingWeight(3))
        println(hammingWeight(6))
        println(hammingWeight(7))
        println(hammingWeight(9))
        println(hammingWeight(14))
        println(hammingWeight(15))
        println(hammingWeight((Math.pow(2, 32).toLong - 1).toInt))
        println(hammingWeight((Math.pow(2, 32)).toInt))
        println((Math.pow(2, 32)).toInt)
    }
}
