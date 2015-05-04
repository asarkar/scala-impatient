package name.abhijitsarkar.scala.scalaimpatient.files

import scala.io.Source
import scala.util.Properties.lineSeparator

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import name.abhijitsarkar.scala.scalaimpatient.files.Chapter9.findLongWords
import name.abhijitsarkar.scala.scalaimpatient.files.Chapter9.imgSrc
import name.abhijitsarkar.scala.scalaimpatient.files.Chapter9.reverse
import name.abhijitsarkar.scala.scalaimpatient.files.Chapter9.stats

class Chapter9Spec extends UnitSpec {
  "Method reverse" should "return the input reversed" in {
    val mockSrc = Source.fromString(f"a b c$lineSeparator%sb")

    val output = reverse(mockSrc).split("\\n")
    output.size should be(2)
    output should contain("b")
    output should contain("a b c")

    mockSrc.close()
  }

  "Method findLongWords" should "find words longer than the given length" in {
    val mockSrc = Source.fromString(f"This is a long word$lineSeparator%sShort word")

    val output = findLongWords(mockSrc, 10)

    output.size should be(1)
    output should contain("This is a long word")
  }

  "Method stats" should "return the sum, average, maximum and minimum of a sequence of numbers" in {
    val mockSrc = Source.fromString(f"1.0$lineSeparator%s2.0$lineSeparator%s3.0$lineSeparator%s4.0")

    val (sum, avg, max, min) = stats(mockSrc)

    sum should be(10.0)
    avg should be(2.5)
    max should be(4.0)
    min should be(1.0)
  }

  "Method imgSrc" should "find src attributes of all img tags in mock web page" in {
    val content = """<a href="#search" onclick="_gaq.push(['_trackPageview', '/search']); 
                    return Manager.createHistoryAndLoad(true);">
                    <img src="ajaxsolr/images/centralRepository_logo.png" alt="The Central Repository" />
                  </a>"""
    imgSrc(content) should contain("ajaxsolr/images/centralRepository_logo.png")
  }
}