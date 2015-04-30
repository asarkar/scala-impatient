package name.abhijitsarkar.scala.scalaimpatient.arrays

import scala.util.Random
import java.util.TimeZone.getAvailableIDs

object Chapter3 {
  /**
   * Q1: Write a code snippet that sets `a` to an array of `n` random integers between `0` (inclusive)
   * and `n` (exclusive).
   *
   */
  def nAryArray(n: Int) = {
    /* Scala arrays are compatible with Scala sequences - you can pass an Array[T] where a Seq[T] is required. */
    Array.fill(n)(Random.nextInt(n))
  }

  private def swap(i: Int, a: Array[Int]) = {
    def isOdd(i: Int) = i % 2 != 0
    def isLast(i: Int) = i == a.length - 1

    i match {
      case _ if isLast(i) => Array(a(i))
      case _ if isOdd(i) => Array(a(i), a(i - 1))
      case _ => Array[Int]()
    }
  }

  /**
   * Q2: Write a loop that swaps adjacent elements of an array of integers. For example, `Array(1, 2, 3, 4, 5)`
   *  becomes `Array(2, 1, 4, 3, 5)`.
   *
   */
  def swapWithFor(a: Array[Int]) = {
    (for (i <- 0 until a.length) yield swap(i, a)).flatten.toArray
  }

  def swapWithZipWithIndex(a: Array[Int]) = {
    a.view.zipWithIndex.map { case (value, index) => swap(index, a) }.flatten.toArray
  }

  def swapWithGrouped(a: Array[Int]) = {
    /* The _.reverse notation is a shorthand for x => x.reverse */
    a.grouped(2).flatMap(_.reverse).toArray
  }

  /**
   * Q4: Given an array of integers, produce a new array that contains all the positive values of the original array,
   * in their original order, followed by all values that are zero or negative, in their original order.
   *
   */
  def partition(a: Array[Int]) = {
    /* temp is a Tuple2 of Array[Int] */
    val temp = a.partition(_ >= 0)

    temp._1 ++ temp._2
  }

  /**
   * Q5: How do you compute the average of an `Array[Double]`?
   */
  def avg(a: Array[Double]) = {
    a.sum / a.length
  }

  /**
   * Q6: How do you rearrange the elements of an `Array[Int]` so that they appear in reverse sorted order?
   * How do you do the same with an `ArrayBuffer[Int]`?
   */
  def sortArray(a: Array[Int]) = {
    a.sorted(Ordering[Int].reverse)
    /* This works too */
    // a.sortWith(_ > _)
  }

  /**
   * Q7: Write a code snippet that produces all values from an array with duplicates removed.
   */
  def deDup(a: Array[Int]) = {
    a.groupBy(identity).keySet
  }

  /**
   * Q9: Make a collection of all time zones returned by `java.util.TimeZone.getAvailableIDs` that are in America.
   * Strip the `"America/"` prefix and sort the result.
   */
  def americanTimeZones = {
    val prefix = "America/"

    /* http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html */
    def american: PartialFunction[String, String] = {
      case id if id.startsWith(prefix) => id.stripPrefix(prefix)
    }

    getAvailableIDs.collect(american).sorted
  }
}