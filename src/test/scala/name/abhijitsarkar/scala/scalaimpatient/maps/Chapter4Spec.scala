package name.abhijitsarkar.scala.scalaimpatient.maps

import scala.io.Source

import org.mockito.Mockito.when
import org.scalatest.mock.MockitoSugar

import Chapter4.countWords
import Chapter4.discountGizmos
import Chapter4.lteggt
import Chapter4.minmax
import Chapter4.sysProps
import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class Chapter4Spec extends UnitSpec with MockitoSugar {
  "discountedGizmos method" should "reduce all prices by 10%" in {
    val gizmos = Map("Leica M9" -> 4950.00, "Hasselblad H5D-200c" -> 45000.00)

    val discountedGizmos = discountGizmos(gizmos)

    discountedGizmos should contain(("Leica M9", 4950.00 - 4950.00 * 0.9))
    discountedGizmos should contain(("Hasselblad H5D-200c", 45000.00 - 45000.00 * 0.9))
  }

  "countWords method" should "count words" in {
    def lines = {
      List("a b c", "b").iterator
    }

    val mockSrc = mock[Source]
    when(mockSrc.getLines).thenReturn(lines)

    val wordCount = countWords(mockSrc)

    wordCount should contain(("a", 1))
    wordCount should contain(("b", 2))
    wordCount should contain(("c", 1))
  }

  "sysProps method" should "return all system properties and the length of the longest key" in {
    println(sysProps)
  }

  "minmax method" should "return minimum and maximum" in {
    val m = minmax(Array(1, 2, 99, -5))

    m should be(-5, 99)
  }

  "lteggt method" should "return a triple" in {
    val t1 = lteggt(Array(-5, -1, 1, 2), 2)

    t1 should equal((3, 1, 0))

    val t2 = lteggt(Array(-5, 1, 3, 5), 2)

    t2 should equal((2, 0, 2))

    val t3 = lteggt(Array(5), 2)

    t3 should equal((0, 0, 1))
  }
}