package name.abhijitsarkar.scala.scalaimpatient.inheritance

/* 'javap -private -c SimpleItem' shows that the abstract methods from the superclass are implemented by the compiler 
 * and they return the values from the corresponding 'val'. This design to "override" 'def' with 'val' is useful if
 * the class is constructed only once but called multiple times. If the 'val' calculation is expensive, it may be
 * slower to construct but when called, the methods would just return the already computed values fast. In the
 * case where the class is constructed multiple times, we're better off overriding and implementing 
 * the abstract methods ourselves.
 * In this case, neither approach makes a difference.
 */
class SimpleItem(val price: Double, val description: String) extends Item {

}