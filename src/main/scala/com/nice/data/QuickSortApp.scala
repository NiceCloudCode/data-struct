package com.nice.data

/**
 * Scala 实现快速排序
 */
object QuickSortApp {

  def main(args: Array[String]): Unit = {
    val list = List(6, 3, 8, 2, 9, 1, 7, 5, 4)
    val sortList = quickSort(list)
    sortList.foreach(println)
  }

  /**
   * 快排
   * 时间复杂度:平均时间复杂度为O(nlogn)
   * 空间复杂度:O(logn)，因为递归栈空间的使用问题
   *
   */
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case List() => List()
      // 取
    case head :: tail =>
      val (left, right) = tail.partition(_ < head)
      quickSort(left) ::: head :: quickSort(right)
  }
}
