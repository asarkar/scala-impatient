package name.abhijitsarkar.scala.scalaimpatient.maps

import collection.mutable.HashMap
import java.util.Scanner
import java.io.File
import scala.collection.mutable.ListBuffer

class Chapter4 {
  def discountGizmos(gizmos: Map[String, Double]) = {
    gizmos.mapValues(0.1*)
  }

  def countWords(in: Scanner) = {
    val maps = new ListBuffer[Map[String, Int]]

    while (in.hasNext())
      maps += in.next().split("\\s").groupBy { identity }.mapValues(_.size)

    /* reduceLeft works on a pair of elements at a time. foldLeft takes an initial value, in this case an empty map,
     * and then adds an entry to it the value for which is the merger of values from both maps for that key.
     */
    maps.reduceLeft((m1, m2) => m1.foldLeft(Map[String, Int]()) {
      case (acc, (k, v)) => acc + (k -> (v + m2.getOrElse(k, 0)))
    })
  }
}