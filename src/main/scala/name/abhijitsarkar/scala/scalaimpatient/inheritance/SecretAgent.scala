package name.abhijitsarkar.scala.scalaimpatient.inheritance

/* Has private final 'name' and 'toString' fields and public methods of the same name. */
class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}