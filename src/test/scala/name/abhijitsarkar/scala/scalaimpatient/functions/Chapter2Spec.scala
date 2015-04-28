package name.abhijitsarkar.scala.scalaimpatient.functions

import org.scalatest.FlatSpec

/**
 * @author Abhijit Sarkar
 */
class Chapter2Spec extends FlatSpec {
  private val ch2 = new Chapter2()

  "pow method" should "return 4 for 2 raised to the power of 2" in {
    assert(ch2.pow(2, 2) == 4)
  }
  
  "pow method" should "return 0.25 for 2 raised to the power of -2" in {
    assert(ch2.pow(2, -2) == 0.25)
  }
  
  "pow method" should "return 1 for 2 raised to the power of 0" in {
    assert(ch2.pow(2, 0) == 1)
  }
}