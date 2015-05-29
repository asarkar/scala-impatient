package name.abhijitsarkar.scala.scalaimpatient.traits

import java.io.InputStream

/* If we were to do an early initialization here, it'd be within curly braces after 'extends' and InputStream 
 * would become 'with'. Note that despite the keyword with, the class needs to be in the first position 
 * and you cannot extend multiple classes.
 */
class MyBufferedInputStream(val input: InputStream, override val bufferSize: Int) extends InputStream with Buffered {
  override def read() = {
    input.read()
  }
}