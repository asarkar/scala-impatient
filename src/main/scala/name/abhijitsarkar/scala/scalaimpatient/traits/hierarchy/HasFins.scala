package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

trait HasFins {
  this: Animal =>
  val numFins: Int
}