package name.abhijitsarkar.scala.scalaimpatient.inheritance

/**
 * Q9: In the `Creature` class of Section 8.10, "Construction order and Early Definitions", replace `val range` with a
 * `def`. What happens when you also use a `def` in the `Ant` subclass? 
 * What happens when you use a `val` in the subclass? Why?
 *
 * Ans: When `val range` is replace with a `def`, instead of generating a private field with public getter, the compiler
 * generates a method that returns 2. When the superclass constructor calls subclass `range`, it gets 2 in return
 * as expected.
 * If range is a `val`, the compiler generates a private field with public getter. When superclass constructor
 * calls subclass `range`, it returns zero because the field `range` has not been initialized yet. Thus the `env`
 * array is created with length zero instead of 2.
 */
class Ant extends Creature {
  override def range = 2
}