package name.abhijitsarkar.scala.scalaimpatient.objects

/**
 * Q6: Write an enumeration describing the four playing card suites so that the `toString` method returns the symbols.
 * 
 * Q7: Implement a function that checks whether a card suit value from the preceding exercise is red.
 */
object Suit extends Enumeration {
  val Spades = Value("\u2660")
  val Hearts = Value("\u2665")
  val Diamonds = Value("\u2666")
  val Clubs = Value("\u2663")

  implicit class SuitValue(suit: Value) {
    def isRed = !isBlack
    def isBlack = (suit == Clubs || suit == Spades)
  }
}