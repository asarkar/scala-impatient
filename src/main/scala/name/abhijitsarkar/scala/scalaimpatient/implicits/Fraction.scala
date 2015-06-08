package name.abhijitsarkar.scala.scalaimpatient.implicits

class Fraction(val num: Int, val denom: Int) {
}

class RichFraction(val frac: Fraction) extends Ordered[Fraction] {
  override def compare(that: Fraction) = {
    (frac.num / gcd(frac)) compare (that.num / gcd(that))
  }

  def gcd(frac: Fraction): Int = {
    if (frac.denom == 0) frac.num else gcd(Fraction(frac.denom, frac.num % frac.denom))
  }
}

object Fraction {
  implicit def fraction2RichFraction(from: Fraction) = {
    new RichFraction(from)
  }

  def apply(num: Int, denom: Int) = new Fraction(num, denom)
}