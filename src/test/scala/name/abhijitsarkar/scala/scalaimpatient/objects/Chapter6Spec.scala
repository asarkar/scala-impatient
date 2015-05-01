package name.abhijitsarkar.scala.scalaimpatient.objects

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.objects.Suit.SuitValue

class Chapter6Spec extends UnitSpec {
  "InchesToCentimeters object" should "convert" in {
    InchesToCentimeters.convert(1) should be(2.54)
  }

  /* Usually boolean values can be tested by passing the name of the method (minus 'is' prefix) as a symbol to 'be'.
   * Doesn't work for implicit methods.
   */
  "Spades suit" should "be black" in {
    Suit.Spades.isBlack should be(true)
  }

  "Hearts suit" should "be red" in {
    Suit.Hearts.isRed should be(true)
  }
}