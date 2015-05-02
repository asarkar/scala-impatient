package name.abhijitsarkar.scala.scalaimpatient.inheritance

/**
 * Q4: Define an abstract class `Item` with methods `price` and `description`. A `SimpleItem` is an item whose price
 * and description are specified in the constructor. Take advantage of the fact that a `val` can override a `def`. A
 * `Bundle` is an item that contains other items. Its price is the sum of the prices in the bundle. Also provide a
 * mechanism for adding items to the bundle and a suitable `description` method.
 */
abstract class Item {
  def price: Double
  def description: String
}