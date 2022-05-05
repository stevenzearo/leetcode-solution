package junior.romanToInt

/*
* 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
* 字符          数值
* I             1
* V             5
* X             10
* L             50
* C             100
* D             500
* M             1000
*
* 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
*
* 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
*
*     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
*     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
*     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
*
* 给定一个罗马数字，将其转换成整数。

* */
object Solution {
    def romanToInt(s: String): Int = {
        var level: Int = 0
        var sum = 0
        val charArray = s.toCharArray
        for (i <- (0 until charArray.length).reverse) {
            val currentLevel = romanMap.getOrElse(charArray(i), 0)
            if (currentLevel < level) sum -= currentLevel else sum += currentLevel
            level = currentLevel
        }
        sum
    }

    val romanMap: Map[Char, Int] = Map(
        'I' -> 1,
        'V' -> 5,
        'X' -> 10,
        'L' -> 50,
        'C' -> 100,
        'D' -> 500,
        'M' -> 1000
    )

    def main(args: Array[String]): Unit = {
        val s1 = "III"
        val s2 = "IV"
        val s3 = "IX"
        val s4 = "LVIII"
        val s5 = "MCMXCIV"
        assert(romanToInt(s1).equals(3))
        assert(romanToInt(s2).equals(4))
        assert(romanToInt(s3).equals(9))
        assert(romanToInt(s4).equals(58))
        assert(romanToInt(s5).equals(1994))
    }
}