package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

abstract class Aviator extends Animal with HasWings {
  override def name: String = "Aviator"
}