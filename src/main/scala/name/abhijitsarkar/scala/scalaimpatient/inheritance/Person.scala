package name.abhijitsarkar.scala.scalaimpatient.inheritance

/**
 * Q8: Compile the `Person` and `SecretAgent` classes in Section 8.10, "Overriding Fields" and analyze the class files
 * with `javap`. How many `name` fields are there? How many `name` getter methods are there? What do they get?
 */
/* Has a private final 'name' and public 'name' and 'toString' methods. */
class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}