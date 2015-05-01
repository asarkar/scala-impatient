package name.abhijitsarkar.scala.scalaimpatient.objects

abstract class UnitConversion {
  def convert(from: Double) = {
    from * conversionFactor
  }

  protected def conversionFactor: Double
}
