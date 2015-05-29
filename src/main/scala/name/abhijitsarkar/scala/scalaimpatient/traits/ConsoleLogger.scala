package name.abhijitsarkar.scala.scalaimpatient.traits

trait ConsoleLogger extends Logged {
  override def log(msg: String) { println(msg) } 
}