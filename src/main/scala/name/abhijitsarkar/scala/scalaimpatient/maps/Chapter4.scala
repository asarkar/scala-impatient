package name.abhijitsarkar.scala.scalaimpatient.maps

import scala.io.Source
import scala.sys.SystemProperties

object Chapter4 {
  /**
   * Q1: Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the same keys
   * and the prices at a 10 percent discount.
   */
  def discountGizmos(gizmos: Map[String, Double]) = {
    gizmos.mapValues(0.1*)
  }

  /**
   * Q2/Q3/Q4: Write a program that reads words from a file. Use a mutable map to count how often each word appears.
   * To read the words, simply use a `java.util.Scanner`.
   * At the end, print out all the words and their counts.
   */
  def countWords(src: Source) = {
    src.getLines.flatMap { _.split("\\s") }.foldLeft(Map[String, Int]()) {
      /* map + tuple notation returns new immutable map with tuple added. For a mutable map, the initial map needs
       * to be mutable and instead of '+', we'd use '='
       */
      case (wordCount, word) => wordCount + (word -> (wordCount.getOrElse(word, 0) + 1))
    }
  }

  /**
   * Q7: Print a table of all Java properties.
   * You need to find the length of the longest key before you can print the table.
   *
   */
  def sysProps = {
    val props = new SystemProperties().keySet

    val longestPropLen = if (!props.isEmpty) props.map(_.length).reduceLeft(_ max _) else 0

    (props, longestPropLen)
  }

  /**
   * Q8: Write a function `minmax(values: Array[Int])` that returns a pair containing the smallest and largest values
   * in the array.
   */
  def minmax(values: Array[Int]) = {
    values.foldLeft((0, 0)) {
      case ((min, max), v) => (v.min(min), v.max(max))
    }
  }

  /**
   * Q9: Write a function `lteggt(values: Array[Int], v: Int)` that returns a triple containing the counts of values
   * less than `v`, equal to `v`, and greater than `v`.
   */
  def lteggt(values: Array[Int], v: Int) = {
    values.foldLeft((0, 0, 0)) {
      case ((lessThan, equal, greaterThan), el) => {
        if (el < v)
          (lessThan + 1, equal, greaterThan)
        else if (el > v)
          (lessThan, equal, greaterThan + 1)
        else (lessThan, equal + 1, greaterThan)
      }
    }
  }
}