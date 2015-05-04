package name.abhijitsarkar.scala.scalaimpatient.inheritance

class Chapter8 {
  /**
   * Q10: The file `scala/collection/immutable/Stack.scala` contains the definition
   *
   * `class Stack[A] protected (protected val elems: List[A])`
   *
   * Explain the meaning of the `protected` keywords.
   *
   * Ans: The first `protected` makes the variable `elems` protected, meaning it can only be accessed (and shadowed) by
   * subclasses of `Stack[+A]`. `+A` means that Stack is covariant in the generic parameter `A`, meaning that `Stack[Dog]`
   * is `Stack[Animal]`. Without the plus sign, the assignment `val x: Stack[Animal] = Stack[Dog](Dog("Pluto"))`
   * is illegal.
   * Contravariance is denoted by the minus sign. However, the variance indicator only appears when declaring a class
   * (or trait), so writing class `Stack[+A](elems: List[-A])` is actually not allowed.
   * If you want to express that elems can be a List of any supertype of A, then you'd probably write
   * `class Stack[+A, B >: A](elems: List[B])`, where `[B >: A`] is like saying `<B super A>` in Java
   * (and `[B <: A]` like saying `<B extends A>`);
   *
   * The second `protected` makes the constructor protected, meaning that a new Stack instance can only be created by
   * subclasses of `Stack[+A]`.
   *
   * The equivalent Java code would be something like:
   * {{{
   * class Stack<A> {
   *   protected List<A> elems;
   *   protected Stack<A>(List<A> elems) {this.elems = elems;}
   * }
   * }}}
   */
  val q10 = ()
}