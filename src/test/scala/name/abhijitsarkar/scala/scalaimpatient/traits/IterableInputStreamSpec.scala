package name.abhijitsarkar.scala.scalaimpatient.traits

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets.UTF_8

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class IterableInputStreamSpec extends UnitSpec {

  "IterableInputStream" should "iterator that traverses over given InputStream" in {
    val it = new IterableInputStream(newInputStream("abc")).iterator

    it.toStream should contain allOf ('a', 'b', 'c')
  }

  private def newInputStream(str: String) = {
    new ByteArrayInputStream(str.getBytes(UTF_8))
  }
}