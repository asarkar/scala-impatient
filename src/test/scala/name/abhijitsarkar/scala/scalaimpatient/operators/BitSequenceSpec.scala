package name.abhijitsarkar.scala.scalaimpatient.operators

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class BitSequenceSpec extends UnitSpec {
  "Setting bit 2" should "should yield 2" in {
    val b = new BitSequence()
    b(2) = true
    true == b(2)

    b.value should be(2)
  }

  "Setting bit 1" should "should yield 1" in {
    val b = new BitSequence()
    b(1) = true
    true == b(1)

    b.value should be(1)
  }

  "Setting bit 1 and 2" should "should yield 3" in {
    val b = new BitSequence()
    b(1) = true
    b(2) = true
    
    true == b(1) && true == b(2)

    b.value should be(3)
  }

  "Setting and unsetting bit 3" should "should yield 4 followed by 0" in {
    val b = new BitSequence()
    b(3) = true

    b.value should be(4)
    
    true == b(3)

    b(3) = false
    
    false == b(3)

    b.value should be(0)
  }

  "Setting bit 91" should "should throw exception" in {
    val b = new BitSequence()
    an[IndexOutOfBoundsException] should be thrownBy (b(91) = true)
  }
}