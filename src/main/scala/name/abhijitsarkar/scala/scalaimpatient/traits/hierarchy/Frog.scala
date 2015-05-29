package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

class Frog(override val name: String) extends Amphibian {
  val numLegs = 4
  /* Even though not technically fins, frog's feet are kinda fins, right? Right? */
  val numFins = 4
  
  override def toString = {
    f"My name is $name%s. I'm a Frog and I've $numLegs%d legs and $numFins%d fins. I'm from the ${super.name}%s family."
  }
}