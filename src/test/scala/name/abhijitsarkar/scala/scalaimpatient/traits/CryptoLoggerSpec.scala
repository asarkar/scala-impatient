package name.abhijitsarkar.scala.scalaimpatient.traits

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class CryptoLoggerSpec extends UnitSpec {
  "Crypto logger" should "use default key length of 3 if not specified otherwise" in {
    val logger = new CryptoLogger {}
    
    logger.log("abc") should be("def")
    logger.log("xyz") should be("abc")
  }
  
  "Crypto logger" should "use key length of -3" in {
    /* Need override keyword */
    val logger = new { override val key = -3 } with CryptoLogger {}
    
    logger.log("abc") should be("def")
    logger.log("xyz") should be("abc")
  }
}