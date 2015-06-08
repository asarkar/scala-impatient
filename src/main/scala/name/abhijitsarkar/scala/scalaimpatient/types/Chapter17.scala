package name.abhijitsarkar.scala.scalaimpatient.types

object Chapter17 {
  /**
   * Q3: Given a class `PAir[T, S]`, write a generic method `swap` that takes a pair as its argument and returns a new
   * pair with the components swapped.
   */
  def swap[T, S](p: Pair1[T, S]): Pair1[S, T] = {
    p.swap
  }

  /**
   * Q4: Why don't we need a lower bound for the `replaceFirst` method in section 17.3, "Bounds for Type Variables",
   * if we want to replace the first component of a `Pair[Person]` with a `Student`?
   *
   * Ans: We don't need the lower bound because the compiler infers the return type as `Pair[Any]`.
   */
  val q4 = ()

  /**
   * Q5: Why does `RichInt` implement `Comparable[Int]` and not `Comparable[RichInt]`?
   *
   * Ans: In order to be able to use the view bound `T <% Comparable[T]` to work, there should exist an implicit
   * conversion from `T` to `Comparable[T]`. `Int` can be implicitly converted to `RichInt` and `RichInt` implements
   * `Comparable[Int]` thus making the view bound work. `Int` to `RichInt` implicit conversion is in
   * `Predef.intWrapper(Int): RichInt` which, in turn, inherits it from `LowPriorityImplicits`. To see this, start
   * the REPL with `-Xprint:typer` option.
   */
  val q5 = ()

  def middle[T <% Iterable[T]](it: T) = {
    val slow = it.sliding(1)
    val fast = it.sliding(1, 2)

    fast.zip(slow).toList.last._2
  }

  /**
   * Q7: Look through the methods of the `Iterable[+A]` trait. Which methods use the type parameter `A`? Why is it in
   * a covariant position in these methods?
   *
   * Ans: I've not looked through all the methods but methods like `foldLeft`, `foldRight` and `aggregate` use the type `A`
   * in a covariant position. That's ok because `A` occurs inside the function parameters
   * and isn't the type that's returned by those functions. As long as the return type is not `Unit` or `A`, the compiler
   * assumes that no modification is done to the data of type `A` in those functions.
   */
  val q7 = ()

  /**
   * In Section 17.10, "Co- and Contravariant Positions", the `replaceFirst` method has a type bound. Why can't you
   * define an equivalent method on a mutable `Pair[T]`?
   *
   * `def replaceFirst[R >: T](newFirst: R) { first = newFirst } // Error`
   *
   * Ans: This is not allowed because if the original `Pair` was of type `Student`, and `newFirst` is of type `Person`,
   * replacing the first element would not change the type of the `Pair`, but we'd end up with a `Pair[Student]` where
   * the 1st element is not a student (obviously not every `Person` is a `Student`). This would be ok if instead
   * if replacing the 1st element, we returned a new `Pair` of type `Person` from method `replaceFirst`.
   * Then the 1st element would be of type `Person` and 2nd element of type `Student` and obviously,
   * every `Student` is also a `Person`.
   *
   */
  val q8 = ()
}