package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

abstract class Terrestrial extends Animal with HasLegs {
  /* This needs to be an override of Animal.name */
  override def name: String = "Terrestrial"
}