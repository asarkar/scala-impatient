package name.abhijitsarkar.scala.scalaimpatient.implicits

import java.awt.Point

import scala.math.sqrt

object Chapter21 {
  /**
   * Q1: How does `->` work? That is, how can `"Hello" -> 42` and `42 -> "Hello"` be pairs `("Hello, 42")` and
   * `(42, "Hello")`?
   *
   * Ans: This was previously made possible by implicit method `Predef.any2ArrowAssoc`. However, since Scala 2.10, implicit
   * methods have been supplanted by implicit classes, which provide a safer and more limited scope for converting
   * existing instances. Thus this is now done by the implicit class `Predef.ArrowAssoc`.
   */
  val q1 = ()

  implicit final class IntAssoc(val x: Int) {
    /**
     * Q2: Define an operator `+%` that adds a given percentage to a value. For example, `120 +% 10` should be 132.
     */
    def +%(y: Int) = x + x / y

    /**
     * Q3: Define a `!` operator that computes the factorial of an integer. For example, `5!` is 120. You will need an
     * enrichment class and an implicit conversion.
     */
    def ! = (1 to x).foldLeft(1) { _ * _ }
  }

  /**
   * Q5: Provide the machinery that is needed to compute
   *
   * `smaller(Fraction(1, 7), Fraction(2, 9))`
   *
   * in Section 21.6, "Implicit Conversion with Implicit Parameters". Supply a class `RichFraction` that extends
   * `Ordered[Fraction].`
   */
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b

  def smallerPoint(a: Point, b: Point)(implicit ordering: Ordering[Point]) = ordering.compare(a, b) < 0

  /**
   * Q6: Compare objects of class `java.awt.Point` by lexicographical comparison.
   */
  final class LexocigraphicalPointOrdering extends Ordering[Point] {
    override def compare(a: Point, b: Point) = {
      val xComparison = a.getX compare b.getX

      if (xComparison != 0) xComparison else (a.getY compare b.getY)
    }
  }

  /**
   * Q7: Continue with the previous exercise, comparing two points according to their distance to the origin. How can
   * you switch between the two orderings?
   *
   * Ans: I can switch between the two orderings by defining an `implicit val order: Ordering[Point] = ?` in the current
   * scope.
   */
  final class DistancePointOrdering extends Ordering[Point] {
    override def compare(a: Point, b: Point) = {
      val aDist = sqrt(a.getX * a.getX + a.getY * a.getY)
      val bDist = sqrt(b.getX * b.getX + b.getY * b.getY)

      aDist compare bDist
    }
  }

  /**
   * Q8: Use the `implicitly` command in the REPL to summon the implicit objects described in Section 21.5,
   * "Implicit Parameters" and Section 21.6, "Implicit Conversions with Implicit Parameters". What objects do you get?
   *
   * Ans: As of v2.11.6, the command to see all implicits in scope is `:implicits -v`
   */
  val q8 = ()
}