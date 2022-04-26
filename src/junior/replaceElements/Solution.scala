package junior.replaceElements

/**
 * @author steve
 */

/*
* https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
* 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
* 完成所有替换操作后，请你返回这个数组。
* */
object Solution {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    arr.indices.map(i => {
      if (i == arr.length - 1) -1 else arr.slice(i + 1, arr.length).reduce((a, b) => if (a > b) a else b)
    }).toArray
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(17, 18, 5, 4, 6, 1)
    val ints = replaceElements(arr)
    println(ints.map(_.toString).reduce((a, b) => s"$a, $b"))
  }
}