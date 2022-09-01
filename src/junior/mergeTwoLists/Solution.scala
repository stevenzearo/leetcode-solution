package junior.mergeTwoLists

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
object Solution {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var arr = toArray(list1) ++ toArray(list2)
    arr = arr.sortWith(_ < _)
    toListNode(arr)
  }

  def toArray(ln: ListNode): Array[Int] = {
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

  def toListNode(arr: Array[Int]): ListNode = {
    if (arr.isEmpty) return new ListNode()
    val head = new ListNode(arr(0))
    var cursor = head
    for (i <- 1 until arr.length) {
      cursor.next = new ListNode(arr(i))
      cursor = cursor.next
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val lsn1 = new ListNode()
    val lsn2 = new ListNode()
    val node = mergeTwoLists(lsn1, lsn2)
    assert(node.x == 0)
    assert(node.next == null)

    val lsn3 = new ListNode(1)
    lsn3.next = new ListNode(3)
    val lsn4 = new ListNode(2)
    lsn4.next = new ListNode(4)

    val node2 = mergeTwoLists(lsn3, lsn4)
    assert(node2.x == 1)
    assert(node2.next.x == 2)
    assert(node2.next.next.x == 3)
    assert(node2.next.next.next.x == 4)

  }
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}