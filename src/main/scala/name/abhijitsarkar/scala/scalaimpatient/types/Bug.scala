package name.abhijitsarkar.scala.scalaimpatient.types

object Show
object ThenBugsy
object Around

/**
 * Q1: Implement a `Bug` class modeling a bug that moves along a horizontal line. The `move` method moves in the current
 * direction, the `turn` method makes the bug turn around, and the `show` method prints the current position. Make
 * these methods chainable. For example:
 *
 * `bugsy.move(4).show().move(6).show().turn().move(5).show()`
 *
 * should display `4 10 5`.
 *
 * Q2: Provide a fluent interface for the `Bug` class of the preceding exercise, so that one can write
 *
 * `bugsy move 4 and show and then move 6 and show turn around move 5 and show`
 */
class Bug {
  private var position: Int = 0

  def move(units: Int): this.type = {
    position += units

    this
  }

  def currentPosition = position

  def show: this.type = {
    println(position)

    this
  }

  def turn(): this.type = {
    move(-position)
  }

  def and(s: Show.type): this.type = show
  def and(at: ThenBugsy.type): this.type = this
  def turn(a: Around.type): this.type = turn()
}