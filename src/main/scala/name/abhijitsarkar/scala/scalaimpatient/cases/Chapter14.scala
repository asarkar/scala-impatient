package name.abhijitsarkar.scala.scalaimpatient.cases

object Chapter14 {
  def swap(p: Tuple2[Int, Int]) = {
    p match {
      case t => t.swap
    }
  }

  def swap(arr: Array[Int]) = {
    arr match {
      case Array(x, y, rest @ _*) => Array(y, x, rest)
      case _ => arr
    }
  }

  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, discount, items @ _*) => items.map { price }.sum - discount
    case Multiple(count, item, _*) => price(item) * count
  }

  /**
   * Q5: One can use lists to model trees that store values only in the leaves. For example, the list ((3, 8) 2 (5))
   * describes the tree
   *      .
   *    . 2   .
   *  3   8  5
   *
   *  However, some of the list elements are numbers and others are lists. In Scala, you cannot have heterogeneous lists,
   *  so you have to use a `List[Any]`. Write a `leafSum` function to compute the sum of all elements in the leaves,
   *  using pattern matching to differentiate between numbers and lists.
   *
   */
  def leafSum(lst: List[Any]): Int = {
    /*
     * These types are indistinguishable because of type erasure, both are just Tuple2 at runtime.
     */
    //    type Node = Tuple2[_, List[Any]]
    //    type Leaf = Tuple2[Int, Int]

    lst.foldLeft(0) {
      case (sum, node: List[_]) => sum + leafSum(node)
      case (sum, leaf: Int) => sum + leaf
    }
  }

  def leafSum2(lst: List[Any]): Int = {
    lst.collect {
      case node: List[Any] => leafSum2(node)
      case leaf: Int => leaf
    }.sum
  }
  /**
   * Q6: A better way (than using `List[Any]`) of modeling trees is with case classes. Let's start with binary trees:
   *
   * `sealed abstract class BinaryTree`
   *
   * `case class BinTreeLeaf(value: Int) extends BinaryTree`
   *
   * `case class BinTreeNode(left: BinaryTree, right: BinaryTree) extends BinaryTree`
   *
   * Write a function to compute the sum of all elements in the leaves.
   */
  def leafSum(tree: BinaryTree): Int = tree match {
    case node: BinTreeNode => leafSum(node.left) + leafSum(node.right)
    case leaf: BinTreeLeaf => leaf.value
  }

  /**
   * Q7: Extends the tree in the preceding exercise so that each node can have an arbitrary number of children, and
   * reimplement the `leafSum` function. The tree in exercise 5 should be expressible as
   * `Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))`
   */
  def leafSum(tree: Tree): Int = tree match {
    case node: Node => node.children.map { leafSum }.sum
    case Leaf(value) => value // different style of case match, just for illustration
  }

  /**
   * Q8: Extends the tree in the preceding exercise so that each non-leaf node stores an operator in addition to
   * the child nodes. Then write a function `eval` that computes the value. For example, the tree
   *
   *         +
   *    *    2    -
   *  3   8      5
   *
   * has a value (3 * 8) + 2 + (-5) = 21
   *
   */
  def eval(expr: ExpressionTree): Int = expr match {
    case ExprTreeNode('+', children @ _*) => children.foldLeft(0) { _ + eval(_) }
    case ExprTreeNode('*', children @ _*) => children.foldLeft(1) { _ * eval(_) }
    case ExprTreeNode('/', children @ _*) => children.foldLeft(1) { (acc, elem) => eval(elem) / acc }
    case ExprTreeNode('-', child) => eval(child).unary_- // Order matters here, 'children @ _*' would match 1 child
    case ExprTreeNode('-', children @ _*) => children.foldLeft(0) { (acc, elem) => eval(elem) - acc }
    case leaf: ExprTreeLeaf => leaf.value
  }

  /**
   * Q10: Write a function that composes two functions of type `Double => Option[Double]`, yielding another function
   * of the same type. The composition should yield `None` if either function does. For example,
   *
   * `def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None`
   *
   * `def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None`
   *
   * `val h = compose(f, g)`
   *
   * Then `h(2)` is `Some(2.41)`, `h(0)` is `Some(-1)` and `h(1)` is `None`.
   */
  def compose(f: Double => Option[Double], g: Double => Option[Double]) = {
    /* http://blog.originate.com/blog/2014/06/15/idiomatic-scala-your-options-do-not-match */
    d: Double =>
      f(d) match {
        case Some(a) => g(a)
        case None => None
      }
  }
}