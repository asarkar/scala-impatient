package name.abhijitsarkar.scala.scalaimpatient.types

import scala.collection.Searching.Found
import scala.collection.Searching.InsertionPoint
import scala.collection.Searching.search
import scala.util.Try

object Chapter18 {
  /**
   * Q6: The `EIther` type in the Scala library can be used for algorithms that return either a result or some failure
   * information. Write a function that takes two parameters: a sorted array of integers and an integer value. Return
   * either the index of the value in the array or the index of the element that is closest to the value. Use an infix
   * type as the return type.
   *
   * Ans: The return type is `(Int, Boolean)` in the infix form. The `Boolean` is `true` if the value was found in the
   * array and `false` if it wasn't.
   */
  def indexOf(arr: Array[Int], v: Int) = {
    type x[Int, Boolean] = (Int, Boolean)

    val matchResult: Int x Boolean = arr.search(v) match {
      case result: Found => (result.foundIndex, true)
      case result: InsertionPoint => (result.insertionPoint, false)
    }

    matchResult
  }

  /**
   * Q7: Implement a method that receives an object of any class that has a method
   *
   * `def close(): Unit`
   *
   * together with a function that processes that object. Call the function and invoke the `close` method upon
   * completion, or when any exception occurs.
   */
  type Closeable = AnyRef { def close(): Unit }

  def acceptCloseable(target: Closeable, f: Closeable => Unit) = {
    /* http://danielwestheide.com/blog/2012/12/26/the-neophytes-guide-to-scala-part-6-error-handling-with-try.html */
    Try(f apply target) recover {
      case _ => target close
    }
  }
}