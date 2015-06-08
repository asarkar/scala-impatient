package name.abhijitsarkar.scala.scalaimpatient.cases

import Chapter14._
import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import scala.math.sqrt
import org.scalactic.Equality

class Chapter14Spec extends UnitSpec {

  "Method leafSum" should "compute the sum of all elements in the leaves of a binary tree" in {
    leafSum(List(List(3, 8), 2, List(5))) should be(18)
  }

  "Method leafSum2" should "compute the sum of all elements in the leaves of a binary tree" in {
    leafSum2(List(List(3, 8), 2, List(5))) should be(18)
  }

  "Method leafSum" should "traverse a binary tree in order" in {
    /**
     *       .
     *   .       .
     * 1   3   7   5
     */
    val BinaryTree = BinTreeNode(BinTreeNode(BinTreeLeaf(1), BinTreeLeaf(3)), BinTreeNode(BinTreeLeaf(7), BinTreeLeaf(5)))

    leafSum(BinaryTree) should be(16)
  }

  "Method leafSum" should "compute the sum of all elements in the leaves of a tree" in {
    val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
    leafSum(tree) should be(18)
  }

  "Method eval" should "evaluate an expression tree" in {
    val expr = ExprTreeNode('+', ExprTreeNode('*', ExprTreeLeaf(3), ExprTreeLeaf(8)), ExprTreeLeaf(2), ExprTreeNode('-', ExprTreeLeaf(5)))

    eval(expr) should be(21)
  }

  "Method compose" should "work as expected" in {
    def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
    def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

    val h = compose(f, g)

    implicit val optionEq = new Equality[Option[Double]] {
      def areEqual(a: Option[Double], b: Any): Boolean = b match {
        /* I know generic type Double is erased at runtime but the compiler needs it for the 'get' method. */
        case o: Option[Double] => !a.isEmpty && (math floor a.get * 100) / 100 == o.get
        case _ => false
      }
    }

    h(2) == Some(2.41)
    h(0) == Some(-1)
    h(1) shouldBe None
  }
}