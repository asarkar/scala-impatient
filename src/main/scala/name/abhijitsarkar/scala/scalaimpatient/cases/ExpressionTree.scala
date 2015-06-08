package name.abhijitsarkar.scala.scalaimpatient.cases

sealed abstract class ExpressionTree
case class ExprTreeLeaf(value: Int) extends ExpressionTree
case class ExprTreeNode(op: Char, children: ExpressionTree*) extends ExpressionTree
