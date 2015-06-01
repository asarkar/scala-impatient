package name.abhijitsarkar.scala.scalaimpatient.operators

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class MatrixSpec extends UnitSpec {
  "The implicit apply and update methods" should "work" in {
    val m = new Matrix(2, 2)

    m(0, 0) = 3

    m(0, 0) should be(3)
  }

  "Multiplying a matrix by a scalar" should "multiply all elements by it" in {
    val m = new Matrix(2, 2, 2)
    val pdt = m * 2

    verifyThatAllElementsEqualTo(m, 2) // original matrix shouldn't be modified
    verifyThatAllElementsEqualTo(pdt, 4)
  }

  "Adding a matrix to itself" should "double all elements" in {
    val m = new Matrix(2, 2, 2)
    val sum = m + m

    verifyThatAllElementsEqualTo(m, 2) // original matrix shouldn't be modified
    verifyThatAllElementsEqualTo(sum, 4)
  }

  private def verifyThatAllElementsEqualTo(m: Matrix, n: Int) = {
    val size = m.size

    for (r <- 0 until size._1) {
      for (c <- 0 until size._2)
        m(r, c) should be(n)
    }
  }

  "Multiplying 2 matrices" should "follow usual matrix multiplication" in {
    /* |2 -1  0|  x |0  1| = |2.0 + (-1).(-2) + 0.0  2.1 + (-1).0 + 0.0| = | 2 2|
     * |0  3  0|    |-2 0|   |0.0 + 3.(-2)    + 0.0  0.1 + 3.0    + 0.0|   |-6 0|
     *              |0  0|
     */
    val m1 = new Matrix(2, 3)
    val m2 = new Matrix(3, 2)

    m1(0, 0) = 2
    m1(0, 1) = -1
    m1(1, 1) = 3

    m2(0, 1) = 1
    m2(1, 0) = -2

    val pdt = m1 * m2

    pdt.size should be((2, 2))

    pdt(0, 0) should be(2)
    pdt(0, 1) should be(2)
    pdt(1, 0) should be(-6)
    pdt(1, 1) should be(0)
  }
  
  "Attempting to multiply 2 matrices that are not multiplication compatible" should "throw exception" in {
    an [IllegalArgumentException] should be thrownBy new Matrix(2, 3) * new Matrix(4, 3)
  }
}