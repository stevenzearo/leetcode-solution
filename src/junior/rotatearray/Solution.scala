package junior.rotatearray

/**
 * @author steve
 */

/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* */

object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
        if (k == 0 || nums.isEmpty) return
        for (_ <- 0 until k) {
            moveOneStep(nums)
        }
    }

    def moveOneStep(nums: Array[Int]): Unit = {
        var previousVal: Int = nums(nums.length - 1)
        for (j <- nums.indices) {
            val currentVal = nums(j)
            nums(j) = previousVal
            previousVal = currentVal
        }
    }

    def main(args: Array[String]): Unit = {
        var nums = Array(1, 2, 3, 4, 5, 6, 7)
        rotate(nums, 3)
        var res = nums.map(_ + "").reduce(_ + ", " + _)
        println("[ " + res + "]")

        nums = Array(-1, -100, 3, 99)
        rotate(nums, 2)
        res = nums.map(_ + "").reduce(_ + ", " + _)
        println("[ " + res + "]")
    }
}
