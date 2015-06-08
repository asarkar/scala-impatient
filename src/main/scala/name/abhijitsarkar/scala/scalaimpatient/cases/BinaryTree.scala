package name.abhijitsarkar.scala.scalaimpatient.cases

sealed abstract class BinaryTree
case class BinTreeLeaf(value: Int) extends BinaryTree
case class BinTreeNode(left: BinaryTree, right: BinaryTree) extends BinaryTree
