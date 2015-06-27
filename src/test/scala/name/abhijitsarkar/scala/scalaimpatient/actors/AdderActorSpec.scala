package name.abhijitsarkar.scala.scalaimpatient.actors

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.actors.Calculator.average

class AdderActorSpec extends UnitSpec {
	"average method" should "distribute a sequence to multiple actors and then compute the average from the collected sums" in {
    average(10) should be(5.5)
  }
}