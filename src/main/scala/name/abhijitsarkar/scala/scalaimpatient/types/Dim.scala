package name.abhijitsarkar.scala.scalaimpatient.types

/**
 * Q9: Consider the following `Dim` class that models a physical dimension and a concrete subclass `Seconds`.
 * But a knucklehead could define a class `Meters` allowing meters and seconds to be added. Use a self type to
 * prevent that.
 */
abstract class Dim[T](val value: Double, val name: String) {
  protected def create(v: Double): T
  def +(other: Dim[T]) = create(value + other.value)
  override def toString() = value + " " + name
}

class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  this: Seconds =>
  override val value = v
  override def create(v: Double) = new Seconds(v)
}

class Meters(v: Double) extends Dim[Seconds](v, "m") {
  override def create(v: Double) = new Seconds(v)
}
