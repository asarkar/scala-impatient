package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

class Dog(override val name: String) extends Terrestrial {
  /* Since the trait specified this as a val, the implementation
   * also needs to be a val */
  val numLegs = 4

  override def toString = {
    f"My name is $name%s. I'm a Dog and I've $numLegs%d legs. I'm from the ${super.name}%s family."
  }
}