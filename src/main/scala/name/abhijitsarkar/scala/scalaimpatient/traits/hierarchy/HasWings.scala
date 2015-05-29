package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

trait HasWings {
  this: Animal =>
  val numWings: Int
}