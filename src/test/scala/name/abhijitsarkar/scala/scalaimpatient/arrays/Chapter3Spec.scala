package name.abhijitsarkar.scala.scalaimpatient.arrays

import org.scalatest.FlatSpec
import org.scalatest.Matchers

import Chapter3.deDup
import Chapter3.partition
import Chapter3.swapWithFor
import Chapter3.swapWithGrouped
import Chapter3.swapWithZipWithIndex

class Chapter3Spec extends FlatSpec with Matchers {

  /* Arrays need 'deep' comparison for equality */

  "swapWithFor method" should "swap adjacent elements of array" in {
    Array(2, 1, 4, 3, 5) should equal(swapWithFor(Array(1, 2, 3, 4, 5)))
  }

  "swapWithZipWithIndex method" should "swap adjacent elements of array" in {
    Array(2, 1, 4, 3, 5) should equal(swapWithZipWithIndex(Array(1, 2, 3, 4, 5)))
  }

  "swapWithGrouped method" should "swap adjacent elements of array" in {
    Array(2, 1, 4, 3, 5) should equal(swapWithGrouped(Array(1, 2, 3, 4, 5)))
  }

  "partition method" should "put positives first, followed by zeros and negatives, preserving the original order" in {
    val a = Array(-1, -4, 1, 6, 0)

    Array(1, 6, 0, -1, -4) should equal(partition(a))
  }

  "deDup method" should "eliminate dupes" in {
    val a = Array(1, 4, 5, 1, 6, 5, 2, 8, 1, 9, 2, 1)

    Set(5, 1, 6, 9, 2, 8, 4) should equal(deDup(a))
  }
}