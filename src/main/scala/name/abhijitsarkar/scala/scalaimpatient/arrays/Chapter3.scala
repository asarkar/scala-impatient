package name.abhijitsarkar.scala.scalaimpatient.arrays

import scala.util.Random

class Chapter3 {
  /**Q1: Write a code snippet that sets `a` to an array of `n` random integers between `0` (inclusive) 
   * and `n` (exclusive).
   * 
   */
  def nAryArray(n: Int) = {
    /* Scala arrays are compatible with Scala sequences - you can pass an Array[T] where a Seq[T] is required. */
    Array.fill(n)(Random.nextInt(n))
  }

  /** Q2: Write a loop that swaps adjacent elements of an array of integers. For example, `Array(1, 2, 3, 4, 5)`
   *  becomes `Array(2, 1, 4, 3, 5)`.
   * 
   */
  def swapAdjacent(a: Array[Int]) = {
    a.grouped(2).map {
      case Array(x, y) => Array(y, x)
      // TODO: Use identity function here
      case Array(x) => Array(x)
    }.flatten.toArray
  }
}