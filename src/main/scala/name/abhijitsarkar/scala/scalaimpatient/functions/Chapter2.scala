package name.abhijitsarkar.scala.scalaimpatient.functions

import scala.math.{ pow => mathPow }

/**
 * @author Abhijit Sarkar
 */
class Chapter2 {
  /**
   * Q1: The ''signum'' of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero.
   * Write a function that computes this value.
   */
  def signum(x: Int) = {
    if (x > 0) 1
    else if (x < 0) -1
    else 0
  }

  /**
   * Q2: What is the value of an empty block expression `{}`? What is its type?
   *
   * Ans: The value is `()`. The type is `Unit`.
   */
  def document: Unit = {

  }

  /**
   * Q4: Write a Scala equivalent for the Java loop
   * `for (int i = 10; i >= 0; i--) System.out.println(i);`
   */
  def javaLikeFor(): Unit = {
    for (i <- (10 to 0 by -1)) println(i)
  }

  /**
   * Q8: Write a function `product(s: String)` that computes the product of the Unicode codes of all letters in a
   * string. For example, the product of the characters in `"Hello"` is `9415087488L`.
   *
   */
  def product(s: String) = {
    /* The resulting value is too large for an Integer so we convert it to a Long. Thanks stackoverflow! */
    s.foldLeft(1L)(_ * _.toInt)
  }

  /**
   * Q9: Make the function of the preceding exercise a recursive function.
   */
  def productRecursive(s: String) = {
    def productRecursiveInternal(s: String, acc: Long): Long = {
      val value = acc * s.head.toLong

      if (s.length == 1) value
      else productRecursiveInternal(s.drop(1), value)
    }

    productRecursiveInternal(s, 1L)
  }

  /** Write a function that computes ''x^n^'', where ''n'' is an integer. Use the following recursive definition:
    * ''x^n^ = y^2^'' if ''n'' is even and positive, where ''y = x^n/2^''
    * ''x^n^ = x.x^n-1^'' if ''n'' is odd and positive.
    * ''x^0^ = 1''
    * ''x^n^ = 1/x^-n^'' if n is negative.
    * 
    * Don't use a `return` statement.
    */
  def pow(x: Int, n: Int): Double = {
    def isNonNegative = {
      n >= 0
    }

    def isEven = {
      n % 2 == 0
    }

    if (isNonNegative)
      if (n == 0) 1
      else if (isEven) {
        val y = mathPow(x, n / 2)
        mathPow(y, 2)
      } else x * mathPow(x, n - 1)
    else 1 / mathPow(x, -n)
  }
}