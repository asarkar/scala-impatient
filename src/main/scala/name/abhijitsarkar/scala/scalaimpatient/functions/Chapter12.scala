package name.abhijitsarkar.scala.scalaimpatient.functions

object Chapter12 {
  /**
   * Q1: Write a function `values(fun: (Int) => Int, low: Int, high: Int)` that yields a collection of function inputs
   * and outputs in a given range. For example, `values(x => x * x, -5, 5)` should produce a collection of pairs
   * `(-5, 25), (-4, 16), (-3, 9), ..., (5, 25)`.
   */
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for (i <- low to high) yield { (i, fun(i)) }
  }

  /**
   * Q2: How do you get the largest element in an array with `reduceLeft`?
   */
  def largest(arr: Array[Int]) = {
    arr.reduceLeft { _ max _ }
  }

  /**
   * Q3: Implement the factorial function using `to` and `reduceLeft`, without a loop or recursion.
   */
  def factorial(n: Int) = {
    if (n < 1) 1 else (1 to n).reduceLeft { _ * _ }
  }

  /**
   * Q4: The previous implementation needed a special case when ''n < 1''. Show how you can avoid this with `foldLeft`.
   */
  def factorial2(n: Int) = {
    (1 to n).foldLeft(1) { _ * _ }
  }

  /**
   * Q5: Write a function `largest(fun: (Int) => Int, inputs: Seq[Int])` that yields the largest value of a function
   * within a given sequence of inputs. For example, `largest(x => 10 * x - x * x, 1 to 10)` should return `25`.
   * Don't use a loop or recursion.
   */
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map { fun }.reduceLeft { _ max _ }
  }

  /**
   * Q6: Modify the previous function to return the ''input'' at which the output is the largest. For example,
   * `largestAt(fun: (Int) => Int, inputs: Seq[Int])` should return `5`. Don't use a loop or recursion.
   */
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.reduceLeft { (i, j) => if (fun.apply(i) > fun.apply(j)) i else j }
  }

  /**
   * Q7: It's easy to get a sequence of pairs, for example
   * <p>
   * `val pairs = (1 to 10) zip (11 to 20)`
   *
   * Now suppose you want to do something with such a sequence-say, add up the values. But you can't do
   *
   * `pairs.map(_ + _)`
   *
   * The function `_ + _` takes two `Int` parameters, not an `(Int, Int)` pair. Write a function `adjustToPair`
   * that receives a function of type `(Int, Int) => Int` and returns the equivalent function that operates on a pair.
   * For example, `adjustToPair(_ * _)((6, 7))` is `42`.
   *
   * Then use this function in conjunction with `map` to compute the sums of elements in `pairs`.
   *
   */
  def adjustToPair(f: (Int, Int) => Int) = {
    (t: Tuple2[Int, Int]) => f.apply(t._1, t._2)
  }

  def sumOfPairs(a: Seq[Int], b: Seq[Int]) = {
    val sum = adjustToPair(_ + _)
    (a zip b).map { sum }
  }

  /**
   * Q8: In section 12.8, "Currying", you saw the `corresponds` method used with two arrays of strings. Make a call to
   * `corresponds` that checks whether the elements in an array of strings have the lengths given in an array of
   * integers.
   */
  def isCorrespondingLength(arr: Array[String], len: Array[Int]) = {
    arr.corresponds(len)(_.length == _)
  }

  /**
   * Q9: Implement `corresponds` without currying. Then try the call from the previous exercise. What problem do you
   * encounter?
   *
   * Ans: The compiler can't derive the type using underscores as in the previous exercise.
   */
  def myCorresponds(arr: Array[String], that: Seq[Int], f: (String, Int) => Boolean) = {
    arr.zip(that).find(p => f.apply(p._1, p._2)).isDefined
  }

  def isCorrespondingLength2(arr: Array[String], len: Array[Int]) = {
    myCorresponds(arr, len, _.length == _)
  }

  /**
   * Q10: Implement an `unless` control abstraction that works just like `if`, but with an inverted condition.
   * Does the first parameter need to be a call-by-name parameter? Do you need currying?
   * 
   * Ans: The first parameter doesn't need to be a call-by-name parameter. Since it's evaluated only once, whether the
   * evaluation happens at call site (as in call-by-value) or inside the function (call-by-name)
   * doesn't affect the outcome. Currying, as in `unless2`, provides a nice control abstraction 
   * `unless2(false) { block }` but it's not necessary.
   */
  def unless(condition: () => Boolean, block: => Boolean): Boolean = {
    if (!condition()) block else false
  }

  def unless2(condition: => Boolean)(block: => Boolean): Boolean = {
    if (!condition) block else false
  }
}