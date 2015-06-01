package name.abhijitsarkar.scala.scalaimpatient.operators

/**
 * Q4: Implement a class `Money` with fields for dollars and cents. Supply `+`, `-` operators as well as comparison
 * operators `==` and `<`. For example, `Money(1, 75) + Money (0, 50) == Money (2, 25)` should be `true`. Should you
 * also supply `*` and `/` operators? Why or why not?
 *
 * Ans: I'd supply `*` and `/` operators for operating with scalars only (though for this example I didn't).
 * <p>
 * Consider that you're eating at a restaurant and would like to tip 15%. Wouldn't it be handy to have a `*` operator
 * that takes a `Double` (0.15 in this case) and returns the tip amount? Multiplying Money with Money doesn't make sense
 * so I'd not provide a `*` operator to do that.
 * <p>
 * Consider again that you're eating at a restaurant with 2 friends and would like to split the bill in 3 equal portions.
 * Wouldn't it be handy to have a `/` operator that takes an `Int` (3 in this case) and returns the split amount?
 * Dividing Money with Money doesn't make sense so I'd not provide a `/` operator to do that.
 */
class Money(val dollars: Int, val cents: Int) {
  def +(that: Money) = {
    val overflow = if ((this.cents + that.cents) >= 100) (this.cents + that.cents) - 100 else -1

    if (overflow >= 0)
      new Money(this.dollars + that.dollars + 1, overflow)
    else
      new Money(this.dollars + that.dollars, this.cents + that.cents)
  }

  def -(that: Money) = {
    if (this < that) throw new IllegalArgumentException("Cannot substract a bigger amount from a smaller one.")

    val underflow = if (this.cents < that.cents) 100 - (that.cents - this.cents) else -1

    if (underflow >= 0)
      new Money(this.dollars - that.dollars - 1, underflow)
    else
      new Money(this.dollars - that.dollars, this.cents - that.cents)
  }

  def <(that: Money) = {
    (this.dollars < that.dollars) || (this.dollars == that.dollars && (this.cents < that.cents))
  }

  def ==(that: Money) = {
    (this.dollars == that.dollars) && (this.cents == that.cents)
  }
}

object Money {
  def apply(dollars: Int, cents: Int) = new Money(dollars: Int, cents: Int)
}