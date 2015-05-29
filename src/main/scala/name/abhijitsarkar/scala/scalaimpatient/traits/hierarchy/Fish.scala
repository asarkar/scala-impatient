package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

class Fish(override val name: String) extends Marine {
  val numFins = 4
  
  override def toString = {
    f"My name is $name%s. I'm a Fish and I've $numFins%d fins. I'm from the ${super.name}%s family."
  }
}