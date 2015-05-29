package name.abhijitsarkar.scala.scalaimpatient.traits.hierarchy

class Bird(override val name: String) extends Aviator {
  val numWings = 2
  
  override def toString = {
    f"My name is $name%s. I'm a Bird and I've $numWings%d wings. I'm from the ${super.name} family."
  }
}