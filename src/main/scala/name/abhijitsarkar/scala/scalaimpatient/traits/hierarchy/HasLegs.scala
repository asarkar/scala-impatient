package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

trait HasLegs {
  this: Animal =>
  val numLegs: Int
}