package name.abhijitsarkar.scala.scalaimpatient.operators

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class MoneySpec extends UnitSpec {
  "Money(1, 75) + Money(0, 50)" should "== Money(2, 25)" in {
    Money(1, 75) + Money(0, 50) == Money(2, 25)
  }
  
  "Money(2, 75) - Money(2, 50)" should "== Money(0, 25)" in {
    Money(2, 75) - Money(2, 50) == Money(0, 25)
  }
  
  "Money(2, 50)" should "be < Money(2, 75)" in {
    Money(2, 50) < Money(2, 75)
  }
  
  "Money(2, 50) - Money(2, 75)" should "throw exception" in {
    an [IllegalArgumentException] should be thrownBy Money(2, 50) - Money(2, 75)
  }
}