package name.abhijitsarkar.scala.scalaimpatient.implicits

import java.awt.Point

import Chapter21.DistancePointOrdering
import Chapter21.IntAssoc
import Chapter21.LexocigraphicalPointOrdering
import Chapter21.smaller
import Chapter21.smallerPoint
import Fraction.fraction2RichFraction
import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class Chapter21Spec extends UnitSpec {
  "Operator +%" should "return 132 when applied to 120" in {
    120 +% 10 should be(132)
  }

  "Operator !" should "return 120 when applied to 5" in {
    (5!) should be(120)
  }

  "Fraction(1, 7)" should "be smaller than Fraction(2, 9))" in {
    val a = Fraction(1, 7)
    val b = Fraction(2, 9)

    smaller(a, b) == a
  }

  "Fraction(2, 9)" should "be greater than Fraction(4, 44))" in {
    val a = Fraction(2, 9)
    val b = Fraction(4, 44)

    smaller(a, b) == b
  }

  "Fraction(2, 9)" should "be equal to Fraction(4, 18))" in {
    val a = Fraction(2, 9)
    val b = Fraction(4, 18)

    a == b
  }

  "Point(2, 9)" should "be lexicographically greater than Point(1, 11)" in {
    implicit val order: Ordering[Point] = new LexocigraphicalPointOrdering()
    val a = new Point(2, 9)
    val b = new Point(1, 11)

    smallerPoint(b, a) should be(true)
  }

  "Point(2, 9)" should "be distance from center wise smaller than Point(1, 11)" in {
    implicit val order: Ordering[Point] = new DistancePointOrdering()
    val a = new Point(2, 9)
    val b = new Point(1, 11)

    smallerPoint(a, b) should be(true)
  }
}