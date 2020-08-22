package junior.powerOf3

/**
 * @author steve
 */

/*
* 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
* */

object Solution {
    def isPowerOfThree(n: Int): Boolean = {
        var copyOfN = n
        while (copyOfN > 3) {
            if (copyOfN % 3 != 0) return false
            copyOfN = copyOfN / 3
        }
        if (copyOfN == 3) true else false
    }

    def main(args: Array[String]): Unit = {
        println(isPowerOfThree(0))
        println(isPowerOfThree(9))
        println(isPowerOfThree(27))
        println(isPowerOfThree(45))
    }
}
