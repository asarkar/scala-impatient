package name.abhijitsarkar.scala.scalaimpatient.collections

import Chapter13._
import scala.collection.mutable
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

  "Method q6c" should "reverse a list of integers" in {
    q6c(List(1, 2, 3)) should contain inOrderOnly (3, 2, 1)
  }

  "Method sum" should "return the sum all prices" in {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    sum(prices, quantities) should be(99.95)
  }

  "Method group" should "convert an array of double into a 2D array" in {
    val arr = group(Array(1, 2, 3, 4, 5, 6), 3)

    arr should have length 2

    arr(0) should be(Array(1, 2, 3))
    arr(1) should be(Array(4, 5, 6))
  }

  "Method parFrequency" should "return the frequency of each character in a string" in {
    val freq = parFrequency("harry hacker")
    
    freq should have size 8

    freq('h') should be(2)
    freq('a') should be(2)
    freq('r') should be(3)
    freq('y') should be(1)
    freq(' ') should be(1)
    freq('c') should be(1)
    freq('k') should be(1)
    freq('e') should be(1)
  }
}