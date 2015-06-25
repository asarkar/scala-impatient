package name.abhijitsarkar.scala.scalaimpatient.types

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.types.Network.process
import name.abhijitsarkar.scala.scalaimpatient.types.Network.processQ5

class NetworkSpec extends UnitSpec {
  "Only members from the same network" should "be equal" in {
    val chatter = new Network

    val fred = chatter.join("Fred")
    val barney = chatter.join("Barney")

    fred equals barney should be(true)

    val myFace = new Network
    val wilma = myFace.join("Wilma")

    fred equals wilma should be(false)
    barney equals wilma should be(false)
  }

  "Method process with existential type" should "only accept members from same network" in {
    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val barney = chatter.join("Barney")
    val wilma = myFace.join("Wilma")

    process(fred, barney)
    
    processQ5(fred, wilma)
  }
}