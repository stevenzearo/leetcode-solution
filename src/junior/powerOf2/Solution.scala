package junior.powerOf2

/**
 * @author steve
 */

/*
* 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
* */

object Solution {
    def isPowerOfTwo(n: Int): Boolean = {
        var copyOfN = n
        if (copyOfN == 1) return true
        while (copyOfN >= 4) {
            if (copyOfN % 2 != 0) return false
            copyOfN = copyOfN >>> 1
        }
        if (copyOfN == 2) true else false
    }

    def main(args: Array[String]): Unit = {
        println(isPowerOfTwo(1))
    }
}
