package name.abhijitsarkar.scala.scalaimpatient.traits

/**
 * Q4: Provide a `CryptoLogger` trait that encrypts the log messages with the Caesar cipher. The key should be 3 by
 * default, but it should be overridable by the user. Provide usage examples with the default key and a key of -3.
 */
trait CryptoLogger {
  /* If value not specified becomes abstract field. */
  val key: Int = 3
  val cipher = new CaesarCipher(key)

  def log(msg: String) = {
    msg.map { cipher.encrypt }
  }
}