package name.abhijitsarkar.scala.scalaimpatient.inheritance

import scala.collection.mutable

class Bundle extends Item {
  /* ListBuffer is useful for appending items and sequential traversal 
   * but not for random access, which is better in List. 
   */
  val items = mutable.ListBuffer.empty[Item]

  override def price = {
    items.map(_.price).sum
  }

  override def description = {
    /* http://daily-scala.blogspot.com/2010/05/zipwithindex.html */
    (items.view.zipWithIndex foldLeft "") {
      /* http://docs.scala-lang.org/overviews/core/string-interpolation.html */
      case (acc, (item, index)) => f"$acc%s; Item ${index + 1}%d: ${item.description}%s"
    }.drop(2) // Get rid of the leading '; '
  }

  def add(item: Item) = {
    items += item
  }
}