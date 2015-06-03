package name.abhijitsarkar.scala.scalaimpatient.collections

import Chapter13._
import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class Chapter13Spec extends UnitSpec {
  "Method mapOfindices" should "return a map of char to set of indices" in {
    val m = indexes("Mississippi")
    m should contain key ('i')
    m.get('i').get.toList should contain inOrderOnly (1, 4, 7, 10)
  }

  "Method mapOfindices2" should "return a map of char to set of indices" in {
    val m = indexes2("Mississippi")
    m should contain key ('i')
    m.get('i').get should contain inOrderOnly (1, 4, 7, 10)
  }
  
  "Method zip" should "combine values from a map for which keys present in an array" in {
    zip(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)) should contain inOrderOnly (3, 5)
  }
  
  "Method zip2" should "combine values from a map for which keys present in an array" in {
    zip2(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)) should contain inOrderOnly (3, 5)
  } 
}