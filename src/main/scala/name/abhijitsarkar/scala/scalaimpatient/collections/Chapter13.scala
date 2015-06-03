package name.abhijitsarkar.scala.scalaimpatient.collections

import scala.collection.mutable

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
}