package junior.mergeTwoLists

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
object Solution {
  def mergeTwoLists(list1: ScalaListNode, list2: ScalaListNode): ScalaListNode = {
    var arr = toArray(list1) ++ toArray(list2)
    arr = arr.sortWith(_ < _)
    toListNode(arr)
  }

  def toArray(ln: ScalaListNode): Array[Int] = {
    if (ln == null) return Array[Int]()
    var res = Array[Int]()
    var x = ln
    do {
      val v = x.x
      res = res :+ v
      x = x.next
    } while (x != null)
    res
  }

  def toListNode(arr: Array[Int]): ScalaListNode = {
    if (arr.isEmpty) return new ScalaListNode()
    val head = new ScalaListNode(arr(0))
    var cursor = head
    for (i <- 1 until arr.length) {
      cursor.next = new ScalaListNode(arr(i))
      cursor = cursor.next
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val lsn1 = new ScalaListNode()
    val lsn2 = new ScalaListNode()
    val node = mergeTwoLists(lsn1, lsn2)
    assert(node.x == 0)
    assert(node.next == null)

    val lsn3 = new ScalaListNode(1)
    lsn3.next = new ScalaListNode(3)
    val lsn4 = new ScalaListNode(2)
    lsn4.next = new ScalaListNode(4)

    val node2 = mergeTwoLists(lsn3, lsn4)
    assert(node2.x == 1)
    assert(node2.next.x == 2)
    assert(node2.next.next.x == 3)
    assert(node2.next.next.next.x == 4)

  }
}

class ScalaListNode(_x: Int = 0, _next: ScalaListNode = null) {
  var next: ScalaListNode = _next
  var x: Int = _x
}