package name.abhijitsarkar.scala.scalaimpatient.types

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class BugSpec extends UnitSpec {
  "Making the bug move 4 units followed by 6 units" should "yield current position 10" in {
    val bugsy = new Bug()

    bugsy.move(4).move(6).currentPosition should be(10)
  }

  "Making the bug move 4 units and then turning around" should "yield current position 0" in {
    val bugsy = new Bug()

    bugsy.move(4).turn().currentPosition should be(0)
  }
  
  "Bug" should "support fluent style calls to move, show and turn" in {
    val bugsy = new Bug()
    
    bugsy move 4 and Show and ThenBugsy move 6 and Show turn Around move 5 and Show
  }
}