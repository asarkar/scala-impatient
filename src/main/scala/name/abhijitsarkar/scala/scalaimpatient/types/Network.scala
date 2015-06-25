package name.abhijitsarkar.scala.scalaimpatient.types

import scala.collection.mutable.ArrayBuffer

/**
 * Q4: Implement the `equals` method for the `Member` class that is nested inside the `Network` class in Section 18.2,
 * "Type Projections". For two members to be equal, they need to be in the same network.
 */
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]

    override def equals(that: Any): Boolean = that match {
      case other: Member => true
      case _ => false
    }

    override def hashCode = {
      Network.this.hashCode
    }
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m

    m
  }
}

/**
 * Q5: Consider the type alias
 *
 * `type NetworkMember = n.Member forSome { val n: Network }`
 *
 * and the function
 *
 * `def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)`
 *
 * How does this differ from the `process` function in Section 18.8, "Existential Types"?
 *
 * Ans: `processQ5` below accepts members from two different networks, the other `process` function one doesn't.
 * This is because for `processQ5`, there's no relation between the two different variables `n` in the type alias
 * `NetworkMember`.
 */
object Network {
  def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)

  type NetworkMember = n.Member forSome { val n: Network }

  def processQ5(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
}