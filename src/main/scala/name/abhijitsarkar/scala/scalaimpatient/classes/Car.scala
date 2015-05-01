package name.abhijitsarkar.scala.scalaimpatient.classes

/**
 * Q8: Make a class `Car` with read-only properties for manufacturer, model name, and model year, and a read-write
 * property for the license plate. Supply four constructors. All require the manufacturer and model name. Optionally,
 * model year and license plate can also be specified in the constructor. If not, the model year is set to -1 and
 * the license plate to the empty string. Which constructor are you choosing as the primary constructor? Why?
 * 
 * Ans: I chose the constructor with all read-only properties as the primary because there's no way to set the optional
 * model year field later. If defined as a `val` in the class body, it becomes final and can't be modified.
 * If defined as `var` in the class body, Scala would generate a setter for it which we don't want.
 */
class Car(val manufacturer: String, val modelName: String, val modelYear: Int) {
  private var licensePlate = ""

  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1)
  }

  def this(manufacturer: String, modelName: String, modelYear: Int, licensePlate: String) {
    this(manufacturer, modelName, modelYear)
    this.licensePlate = licensePlate
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName, -1, licensePlate)
  }
}