package name.abhijitsarkar.scala.scalaimpatient.cases

abstract class Item

case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(count: Int, items: Item*) extends Item
