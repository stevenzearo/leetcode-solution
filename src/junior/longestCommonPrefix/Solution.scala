package junior.longestCommonPrefix

/*
*
* 编写一个函数来查找字符串数组中的最长公共前缀。
* 如果不存在公共前缀，返回空字符串 ""。
*
*
* 示例 1：
*
* 输入：strs = ["flower","flow","flight"]
* 输出："fl"
*
* 示例 2：
*
* 输入：strs = ["dog","racecar","car"]
* 输出：""
* 解释：输入不存在公共前缀。
*
* 提示：
*
*     1 <= strs.length <= 200
*     0 <= strs[i].length <= 200
*     strs[i] 仅由小写英文字母组成
*
* */
object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) return ""
    if (strs.length == 1) return strs(0)
    var shortestElem: String = strs(0)
    for (elem <- strs) {
      if (elem.length < shortestElem.length) shortestElem = elem
    }
    if (shortestElem.isEmpty) return shortestElem
    var hasCommonPrefix = true
    var commonPrefix: Array[Char] = Array()
    var currentIndexInShortestElem = 0
    while (hasCommonPrefix) {
      var currentChar = shortestElem(currentIndexInShortestElem)
      var elemContainsChar = true
      for (elem <- strs) {
        if (elem.length < shortestElem.length) hasCommonPrefix = false
        elemContainsChar = elemContainsChar && elem.charAt(currentIndexInShortestElem).equals(currentChar)
      }
      if (elemContainsChar) {
        commonPrefix = commonPrefix :+ currentChar
        currentIndexInShortestElem += 1
        if (shortestElem.length <= currentIndexInShortestElem) hasCommonPrefix = false else
          currentChar = shortestElem(currentIndexInShortestElem)
      } else {
        hasCommonPrefix = false
      }
    }
    new String(commonPrefix)
  }

  def main(args: Array[String]): Unit = {
    val strs1 = Array("flower", "flow", "flight")
    val strs2 = Array("dog", "racecar", "car")
    val strs3 = Array("ab", "a")
    val strs4 = Array("ab", "a", "")
    assert(longestCommonPrefix(strs1).equals("fl"))
    assert(longestCommonPrefix(strs2).equals(""))
    assert(longestCommonPrefix(strs3).equals("a"))
    assert(longestCommonPrefix(strs4).equals(""))
  }
}