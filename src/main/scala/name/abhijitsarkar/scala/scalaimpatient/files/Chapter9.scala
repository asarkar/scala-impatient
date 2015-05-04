package name.abhijitsarkar.scala.scalaimpatient.files

import java.io.ByteArrayOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets.UTF_8

import scala.io.Source
import scala.math.{ max => mathMax }
import scala.math.{ min => mathMin }
import scala.util.Properties.lineSeparator

object Chapter9 {
  /**
   * Q1: Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and so on).
   */
  def reverse(input: Source) = {
    val buffer = new ByteArrayOutputStream
    val output = new OutputStreamWriter(buffer, UTF_8)

    /* getLines doesn't return newline */
    input.getLines.toSeq.reverseIterator.foreach { line => output.write(f"$line%s$lineSeparator%s") }

    output.close()

    buffer.toString(UTF_8.name)
  }

  /**
   * Q3: Write a Scala code snippet that reads a file and prints all the words with more than 12 characters to the
   * console. Extra credit if you can do this in a single line.
   */
  def findLongWords(input: Source, len: Int) = {
    input.getLines.filter { _.length > len }.toList
  }

  /**
   * Q4: Write a Scala program that reads a text file containing only floating-point numbers. Print the sum, average,
   * maximum, and minimum of the numbers in the file.
   */
  def stats(input: Source) = {
    val alpha = 0.5
    val accumulator = (0.0, 0.0, Float.MinValue, Float.MaxValue)

    val (sum, count, max, min) = input.getLines.map(_.toFloat).foldLeft(accumulator) { (acc, num) =>
      var (sum, count, max, min) = acc

      sum += num
      count += 1
      max = mathMax(max, num)
      min = mathMin(min, num)

      (sum, count, max, min)
    }

    (sum, sum / count, max, min)
  }

  /**
   * Q8: Write a Scala program that prints the `src` attribute of all `img` tags of a web page. Use regular expresisons
   * and groups.
   */
  def imgSrc(content: String) = {
    /* http://stackoverflow.com/questions/30022698/scala-regex-to-find-img-src-on-a-web-page/30022964 */
    val src = """(?s)<img\s[^>]*?src\s*=\s*['\"]([^'\"]*?)['\"][^>]*?>""".r 
    //    val src = ".*<img[\\w\\s]+src\\s*=\\s*(\"\\w+\")[\\w\\s]+/>.*".r

    /* src findAllMatchIn content and (src findAllIn content).matchData return the same Iterator[Match], 
     * but first one looks better for Scala syntax
     */
    src findAllMatchIn content map (_.group(1)) toList
  }
}