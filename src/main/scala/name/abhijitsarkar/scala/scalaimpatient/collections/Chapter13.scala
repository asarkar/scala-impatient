package name.abhijitsarkar.scala.scalaimpatient.collections

import scala.collection.immutable.{ HashMap => ImmutableHashMap }
import scala.collection.mutable
import scala.math.ceil

object Chapter13 {
  /**
   * Q1: Write a function that, given a string, produces a map of the indexes of all characters. For example,
   * `indexes("Mississippi")` should return a map associating `'M'` with the set `{0}`, `'i'` with the set
   * `{1, 4, 7, 10}` and so on. Use a mutable map of characters to mutable sets. How can you ensure that the set is
   * sorted?
   *
   * Ans: A `LinkedHashSet` maintains the order of insertion. We iterate left to right
   * in naturally increasing order of indexes. Appending to the `LinkedHashSet` ensures that each subsequent index is
   * added to the set of previous, smaller, indexes.
   */
  def indexes(str: String) = {
    val acc = mutable.Map[Char, mutable.LinkedHashSet[Int]]()

    str.zipWithIndex.foldLeft(acc) { (m, t) =>
      println(f"m = $m%s, t = $t%s.")

      val (ch, idx) = t

      m(ch) = m.getOrElse(ch, mutable.LinkedHashSet[Int]()) + idx

      m
    }
  }

  /**
   * Q2: Repeat the previous exercise, using an immutable map of characters to lists.
   */
  def indexes2(str: String) = {
    val acc = Map[Char, List[Int]]()

    str.zipWithIndex.foldLeft(acc) { (m, t) =>
      println(f"m = $m%s, t = $t%s.")

      val (ch, idx) = t

      m + (ch -> (m.getOrElse(ch, List[Int]()) :+ idx))
    }
  }

  /**
   * Q4: Write a function that receives a collection of strings and a map from strings to integers. Return a collection
   * of integers that are the values in the map corresponding to one of the strings in the collection. For example,
   * given `Array("Tom", "Fred", "Harry")` and `Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)`, return `Array(3, 5)`.
   * Hint: Use `flatMap` to combine the `Option` values returned by `get`.
   */
  def zip(a: Array[String], m: Map[String, Int]) = {
    a.flatMap { m.get } // flatmap removes those options that don't have a value.
  }

  def zip2(a: Array[String], m: Map[String, Int]) = {
    a.collect {
      case str if (m.contains(str)) => m.get(str).get
    }
  }

  /**
   * Q6: Given a list of integers `lst`, what is `(lst :\ List[Int]())(_ :: _)`? `(List[Int]() /: lst)(_ :+ _)`?
   * How can you modify one of them to reverse the list?
   *
   * Ans: q6c is the modified version that reverses the list.
   */
  def q6a(lst: List[Int]) = {
    /*
     * :\ is alternate syntax for foldRight; xs :\ z is the same as xs foldRight z.
     * elem :: lst prepends the element to the list. Same as +:
     * The following is equivalent to: lst.foldRight(List[Int]()) { (i, acc) => i +: lst }
     */
    (lst :\ List[Int]())(_ :: _)
  }
  def q6b(lst: List[Int]) = {
    /*
     * /: is alternate syntax for foldLeft; z /: xs is the same as xs foldLeft z.
     * coll :+ elem appends the element to the collection.
     * The following is equivalent to: lst.foldLeft(List[Int]()) { (acc, i) => acc :+ i }
     */
    (List[Int]() /: lst)(_ :+ _)
  }

  def q6c(lst: List[Int]) = {
    (lst :\ List[Int]())((i, acc) => acc :+ i)
  }

  /**
   * Q7: In section 13.11, "Zipping", the expression `(prices zip quantities) map { p => p._1 * p._2 }` is a bit
   * inelegant. We can't do `(prices zip quantities) map { _ * _ }` because `_ * _ ` is a function with two arguments,
   * and we need a function with one argument that is a tuple. The `tupled` method of the `Function2` object changes
   * a function with two arguments to one that takes a tuple. Apply `tupled` to the multiplication function so you can
   * map it over the list of pairs.
   */
  def sum(prices: List[Double], quantities: List[Int]) = {
    val tupledMultiply = ((x: Double, y: Int) => x * y).tupled

    (prices zip quantities) map tupledMultiply sum
  }

  /**
   * Q8: Write a function that turns an array of `Double` values into a two-dimentional array. Pass the number of
   * columns as a a parameter. For example, with `Array(1, 2, 3, 4, 5, 6)` and three columns, return
   * `Array(Array(1, 2, 3), Array(4, 5, 6))`. Use the `grouped` method.
   */
  def group(arr: Array[Double], col: Int) = {
    val r = Array.ofDim[Double](ceil(arr.length / col) toInt, col)
    val it = arr.grouped(col)

    r.indices.foreach { r(_) = it.next() }

    r
  }

  /**
   * Q10: Harry Hacker reads a file into a string and wants to use a parallel collection to update the letter frequencies
   * concurrently on portions of the string. He uses the following code:
   *
   * `val frequencies = new scala.collection.mutable.HashMap[Char, Int]`
   *
   * `for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1`
   *
   * Why is this a terrible idea? How can he really parallelize the computation?
   *
   * Ans: It is not a good idea because if 2 threads are concurrently updating the same frequency,
   * the result is undefined.
   */
  def parFrequency(str: String) = {
    val freq = ImmutableHashMap[Char, Int]()
    str.par.aggregate(freq)((_, c) => ImmutableHashMap(c -> 1), _.merged(_) {
      case ((k, v1), (_, v2)) => (k, v1 + v2)
    })
  }
}