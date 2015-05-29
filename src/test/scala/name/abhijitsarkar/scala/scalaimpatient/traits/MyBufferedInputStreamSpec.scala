package name.abhijitsarkar.scala.scalaimpatient.traits

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets.UTF_8

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class MyBufferedInputStreamSpec extends UnitSpec {

  "Buffer size" should "be overridable and 4" in {
    new MyBufferedInputStream(newInputStream("abc"), 4).bufferSize should be(4)
  }

  "Buffered Stream" should "read data twice into buffer when bufferSize is smaller than number of bytes available" in {
    val str = new MyBufferedInputStream(newInputStream("abc"), 2) with ConsoleLogger with TimestampLogger

    str.readBuffered() should be('a')
    str.readBuffered() should be('b')
    str.readBuffered() should be('c')
    str.readBuffered() should be(-1)
  }

  "Buffered Stream" should "read data once into buffer when bufferSize is larger than number of bytes available" in {
    val str = new MyBufferedInputStream(newInputStream("abc"), 4) with ConsoleLogger with TimestampLogger

    str.readBuffered() should be('a')
    str.readBuffered() should be('b')
    str.readBuffered() should be('c')
    str.readBuffered() should be(-1)
  }

  private def newInputStream(str: String) = {
    new ByteArrayInputStream(str.getBytes(UTF_8))
  }
}