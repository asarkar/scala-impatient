package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class TraitsHierarchySpec extends UnitSpec {
  "A dog" should "have a name, 4 legs and come from the Terrestrial family" in {
    println(new Dog("Fido").toString)
  }
  
  "A bird" should "have a name, 2 wings and come from the Aviator family" in {
    println(new Bird("Speedy").toString)
  }
  
  "A fish" should "have a name, 4 fins and come from the Animal family" in {
    println(new Fish("Goldie").toString)
  }
  
  "A frog" should "have a name, 4 legs and 4 fins and come from the Amphibian family" in {
    println(new Frog("Frogie").toString)
  }
}