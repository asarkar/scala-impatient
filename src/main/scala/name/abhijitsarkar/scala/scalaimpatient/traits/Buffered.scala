package name.abhijitsarkar.scala.scalaimpatient.traits

import java.io.InputStream

/**
 * Q8: In the `java.io` library, you add buffering to an input stream with a `BufferedInputStream` decorator. Reimplement
 * buffering as a trait. For simplicity, override the `read` method.
 *
 * Q9: Using the logger traits from this chapter, add logging to the solution.
 */
trait Buffered extends Logged {
  self: InputStream =>

  val bufferSize: Int = 1024
  val buff = new Array[Byte](bufferSize)

  /* Number of bytes read so far */
  var pos = 0
  /* Number of bytes stored in the buffer */
  var count = 0

  def readBuffered(): Int = {
    if (isTimeToRefillBuffer) {
      log(f"Time to refill buffer. bufferSize = $bufferSize%d, pos = $pos%d, count = $count%d")
      count = fill()
    }

    if (isDataAvailableInbuffer) {
      log(f"Data available in buffer. bufferSize = $bufferSize%d, pos = $pos%d, count = $count%d")
      getFromBuffer()
    } else -1
  }

  /* Invoke the read method of the InputStream it'll be mixed in with */
  private def fill() = self.read(buff)

  private def isDataAvailableInbuffer = count > 0

  private def isTimeToRefillBuffer = !isDataAvailableInbuffer

  private def getFromBuffer() = {
    val x = buff(pos % bufferSize)

    pos += 1
    count -= 1

    x
  }
}