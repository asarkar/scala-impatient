package name.abhijitsarkar.scala.scalaimpatient.arrays

import org.scalatest.FlatSpec

class Chapter3Spec extends FlatSpec {
  private val ch3 = new Chapter3()

  /* Arrays need 'deep' comparison for equality */

  "swapWithFor method" should "swap adjacent elements of array" in {
    assert(Array(2, 1, 4, 3, 5).deep == ch3.swapWithFor(Array(1, 2, 3, 4, 5)).deep)
  }

  "swapWithZipWithIndex method" should "swap adjacent elements of array" in {
    assert(Array(2, 1, 4, 3, 5).deep == ch3.swapWithZipWithIndex(Array(1, 2, 3, 4, 5)).deep)
  }

  "swapWithGrouped method" should "swap adjacent elements of array" in {
    assert(Array(2, 1, 4, 3, 5).deep == ch3.swapWithGrouped(Array(1, 2, 3, 4, 5)).deep)
  }

  "partition method" should "put positives first, followed by zeros and negatives, preserving the original order" in {
    val a = Array(-1, -4, 1, 6, 0)

    assert(Array(1, 6, 0, -1, -4).deep == ch3.partition(a).deep)
  }

  "deDup method" should "eliminate dupes" in {
    val a = Array(1, 4, 5, 1, 6, 5, 2, 8, 1, 9, 2, 1)

    assert(Set(5, 1, 6, 9, 2, 8, 4) == ch3.deDup(a))
  }
}