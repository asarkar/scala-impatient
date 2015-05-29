package name.abhijitsarkar.scala.scalaimpatient.traits

import scala.math.abs

/* http://en.wikipedia.org/wiki/Caesar_cipher */
class CaesarCipher(val key: Int) {
  def encrypt(c: Char) = {
    val startIdex = if (c.isUpper) 65 else 97

    /* Until someone tells me what is the expected outcome with a negative key, don't bother. */
    ((c - startIdex + abs(key)) % 26 + startIdex).toChar
  }
}