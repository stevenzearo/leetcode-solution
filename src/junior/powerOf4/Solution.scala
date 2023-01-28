package junior.powerOf4

/**
 * @author steve
 */

/*
* 给定一个整数，写一个函数来判断它是否是 4 的幂次方。
* 如果是，返回 true ；否则，返回 false 。整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
* */
object Solution {
  def isPowerOfFour(n: Int): Boolean = {
    var m = n
    while (m != 1) {
      if (m <= 0 || m % 4 != 0) return false
      m = m / 4
    }
    true
  }

  def main(args: Array[String]): Unit = {
    println(isPowerOfFour(0))
    println(isPowerOfFour(4))
    println(isPowerOfFour(-4))
    println(isPowerOfFour(8))
    println(isPowerOfFour(14))
    println(isPowerOfFour(16))
  }
}