package name.abhijitsarkar.scala.scalaimpatient.types

import scala.math.sqrt

/**
 * Q1: Define an immutable class `Pair[T, S]` with a method `swap` that returns a new pair with the components swapped.
 */
class Pair1[T, S](val first: T, val second: S) {
  def swap: Pair1[S, T] = {
    new Pair1(second, first)
  }
}

/**
 * Q2: Define a mutable class `Pair[T]` with a method `swap` that swaps the components of the pair.
 */
class Pair2[T](var first: T, var second: T) {
  def swap = {
    val temp = first
    first = second
    second = temp
  }
}

/**
 * Q9: It may seem strange to restrict type parameters in an immutable class `Pair[+T]`. However, suppose you could define
 *
 * `def replaceFirst(newFirst: T)`
 *
 * in a `Pair[+T]`. The problem is that the method can be overridden in an unsound way.
 * Construct an example of the problem. Define a subclass `NastyDoublePair` of `Pair[Double]` that overrides
 * `replaceFirst` so that it makes a pair with the square root of `newFirst`. Then construct the call
 * `replaceFirst("Hello")` on a `Pair[Any]` that is actually a `NastyDoublePair`.
 */
class Pair9[+T](val first: T, val second: T) {
  /**
   * This doesn't compile because if it did, one could do:
   *
   * val p: Pair9[Any] = new NastyDoublePair(2, 9)
   * p.replaceFirst("Hello")
   */
  //  def replaceFirst(newFirst: T) = {
  //    new Pair9(first, second)
  //  }
}

class NastyDoublePair(val f: Double, val s: Double) extends Pair9[Double](f, s) {
  //  override def replaceFirst(newFirst: Double) = {
  //    super.replaceFirst(newFirst)
  //  }
}

/**
 * Q10: Given a mutable `Pair[S, T]` class, use a type constraint to define a swap method that can be called if the
 * type parameters are the same.
 */
class Pair10[T, S](var first: T, var second: S) {
  def swap(implicit ev: T =:= S, ev2: S =:= T) {
    val temp = first
    first = second
    second = temp
  }
}