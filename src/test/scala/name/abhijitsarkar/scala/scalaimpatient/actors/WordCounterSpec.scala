package name.abhijitsarkar.scala.scalaimpatient.actors

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.actors.WordCounter.countWords
import java.io.File

class WordCounterSpec extends UnitSpec {
  val dir = new File(getClass().getResource("/ch20").toURI())

  "countWords" should "count 3 occurences of the word scala" in {
    countWords(dir, "scala") should be(3)
  }

  "countWords" should "count 2 occurences of the word java" in {
    countWords(dir, "java") should be(2)
  }

  "countWords" should "count -1 when one of the actors throws an exception" in {
    countWords(dir, "scala", true) should be(-1)
  }
}