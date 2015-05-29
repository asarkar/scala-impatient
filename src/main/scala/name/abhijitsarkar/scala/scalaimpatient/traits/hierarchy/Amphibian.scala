package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

abstract class Amphibian extends Animal with HasLegs with HasFins {
  override def name: String = "Amphibian"
}