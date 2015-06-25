package name.abhijitsarkar.scala.scalaimpatient.types

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.types.Chapter18._

class Chapter18Spec extends UnitSpec {
  "Method indexOf" should "return 2 when searching for 2 in sorted array 0, 1, 2, 5" in {
    val result = indexOf(Array[Int](0, 1, 2, 5), 2)

    result._1 shouldBe 2
    result._2 shouldBe true
  }

  "Method indexOf" should "return 1 when searching for 2 in sorted array 0, 3, 5" in {
    val result = indexOf(Array[Int](0, 3, 5), 2)

    result._1 shouldBe 1
    result._2 shouldBe false
  }

  "Method acceptCloseable" should "apply the given function to a closeable and also invoke close in case of exception" in {
    class TestCloseable(var s: String) { def close(): Unit = { s = "Close called" } }

    def goodFn(closeable: Closeable) = { closeable.asInstanceOf[TestCloseable].s = "Good" }
    def badFn(closeable: Closeable) = throw new RuntimeException

    val t = new TestCloseable("")

    acceptCloseable(t, goodFn); t.s shouldBe "Good"

    acceptCloseable(t, badFn); t.s shouldBe "Close called"
  }
}