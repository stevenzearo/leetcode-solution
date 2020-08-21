package junior.parenthesis

/**
 * @author steve
 */
/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
object Solution {
    val parentheses = Set("()", "[]", "{}")

    def isValid(s: String): Boolean = {
        if (s.isEmpty) return true
        if (s.length % 2 != 0) return false
        stripPair(s).isEmpty
    }

    def stripPair(s: String): String = {
        var copyOfS = s
        if (copyOfS.isEmpty) return copyOfS
        var noPairCount = 0
        while (noPairCount < 3) {
            noPairCount = 0
            for (pair <- parentheses) {
                if (copyOfS.contains(pair)) {
                    copyOfS = copyOfS.replaceAll("\\" + pair.charAt(0) + "\\" + pair.charAt(1), "")
                } else {
                    noPairCount += 1
                }
            }
        }
        copyOfS
    }

    def main(args: Array[String]): Unit = {
        println(isValid("()"))
        println(isValid("{()}"))
        println(isValid("{}[()]"))
        println(isValid("()[]{}"))
        println(isValid("{()[]}(){()}()"))
        println(isValid("{()]"))
    }
}
