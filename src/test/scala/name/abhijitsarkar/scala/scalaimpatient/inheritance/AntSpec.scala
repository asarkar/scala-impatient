package name.abhijitsarkar.scala.scalaimpatient.inheritance

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class AntSpec extends UnitSpec {
  "Ant" should "be able to see 2 units ahead" in {
    new Ant().env.length should be(2)
  }
}