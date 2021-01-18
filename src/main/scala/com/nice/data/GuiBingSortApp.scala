package com.nice.data

object GuiBingSortApp {
  def main(args: Array[String]): Unit = {
  }

  /**
   * 快排
   * 时间复杂度:O(nlogn)
   * 空间复杂度:O(n)
   */
  def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
    case (Nil, _) => right
    case (_, Nil) => left
    case (x :: xTail, y :: yTail) =>
      if (x <= y) x :: merge(xTail, right)
      else y :: merge(left, yTail)
  }

}
