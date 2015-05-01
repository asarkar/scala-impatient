package name.abhijitsarkar.scala.scalaimpatient

import name.abhijitsarkar.scala.scalaimpatient.classes.BankAccount

class Chapter5Spec extends UnitSpec {
  "Bank account balance" should "change after withdrawal or deposit" in {
    val ac = new BankAccount(5.0)
    
    def bringAcountBalanceTo(amount: Double) = be(amount) 
    
    ac.withdraw(1.0) should bringAcountBalanceTo(4.0)
    ac.deposit(1.0) should bringAcountBalanceTo(5.0)
  }
}