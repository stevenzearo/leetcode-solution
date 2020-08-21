package junior.trailingzeroes

/**
 * @author steve
 */

/*
*
*给定一个整数 n，返回 n! 结果尾数中零的数量。
* */

object Solution {
    def trailingZeroes(n: Int): Int = {
     get5Count(n, 0)
    }

    @scala.annotation.tailrec
    def get5Count(n: Int, originCount: Int): Int = {
        if (n >= 5)
            get5Count(n / 5, originCount + (n / 5))
        else originCount
    }

    def main(args: Array[String]): Unit = {
        println(trailingZeroes(5))
    }
}
