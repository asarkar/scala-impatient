package name.abhijitsarkar.scala.scalaimpatient.operators

object Chapter11 {
  /**
   * Q1: According to the precedence rules, how are `3 + 4 -5` and `3 -> 4 + 5` evaluated?
   *
   * Ans: `3 + 4 -5` is evaluated as `(3 + 4) - 5` because `+` and `-` have the same precedence, and are left-associative.
   * <p>
   * `3 -> 4 - 5` is evaluated as `(3 -> 4) - 5` because the 1st char of `->` is a `-` which has the same precedence
   * as the other `-`. Hence the expression is evaluated left-to-right. It doesn't compile because `3 -> 4` evaluates
   * to a pair `(3, 4)` of type `(Int, Int)` and that class doesn't have a `-` operator.
   */
  val q1 = ()
  
  /**
   * Q2: The `BigInt` class has a `pow` method, not an operator. Why didn't the Scala library designers choose `**`
   * (as in Fortran) or ^ (as in Pascal) for a power operator?
   * 
   * Ans: Scala determines operator precedence based on the 1st character of the operator name. Since `*` is the
   * multiplication operator, it'd not be possible to determine precedence by just looking at the 1st
   * character of `**`. As for ^, it conflicts with the existing bitwise-XOR operator.
   */
  val q2 = ()
}