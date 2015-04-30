package name.abhijitsarkar.scala.scalaimpatient.functions

import org.scalatest.FlatSpec
import org.scalatest.Matchers

import Chapter2.pow

/**
 * @author Abhijit Sarkar
 */
class Chapter2Spec extends FlatSpec with Matchers {
  "pow method" should "return 4 for 2 raised to the power of 2" in {
    pow(2, 2) should be(4)
  }

  "pow method" should "return 0.25 for 2 raised to the power of -2" in {
    pow(2, -2) should be(0.25)
  }

  "pow method" should "return 1 for 2 raised to the power of 0" in {
    pow(2, 0) should be(1)
  }
}