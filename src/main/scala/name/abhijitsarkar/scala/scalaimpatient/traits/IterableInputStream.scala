package name.abhijitsarkar.scala.scalaimpatient.traits

import java.io.InputStream
import scala.collection.AbstractIterator

/**
 * Q10: Implement a class `IterableInputStream` that extends `java.io.InputStream` with the trait `Iterable[Byte]`.
 */
class IterableInputStream(val input: InputStream) extends InputStream with Iterable[Byte] {
  override def iterator: Iterator[Byte] = {
    new AbstractIterator[Byte]() {
      override def hasNext = {
        input.available() > 0
      }

      override def next() = {
        read().toByte
      }
    }
  }

  override def read() = {
    input.read()
  }
}