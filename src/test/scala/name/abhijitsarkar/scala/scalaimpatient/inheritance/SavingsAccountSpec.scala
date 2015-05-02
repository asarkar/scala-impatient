package name.abhijitsarkar.scala.scalaimpatient.inheritance

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

/**
 * @author Abhijit
 */
/* http://www.thecalculatorsite.com/finance/calculators/compoundinterestcalculator.php */
class SavingsAccountSpec extends UnitSpec {
  "Savings account with initial balance 1000 and two $100 withdrawals" should "earn an interest of $4" in {
    val ac = new SavingsAccount(1000)

    1 to 2 foreach { _ => ac.withdraw(100) }
    
    ac.earnMonthlyInterest() should be(4)
  }
  
  "Savings account with initial balance 1000 and two $100 deposits" should "earn an interest of $6" in {
    val ac = new SavingsAccount(1000)

    1 to 2 foreach { _ => ac.deposit(100) }
    
    ac.earnMonthlyInterest() should be(6)
  }
  
  "Savings account with initial balance 1000 and two $200 deposits and two $150 withdrawals" should 
    "earn an interest of $5.50" in {
    val ac = new SavingsAccount(1000)

    1 to 2 foreach { _ => ac.deposit(200) }
    1 to 2 foreach { _ => ac.withdraw(150) }
    
    ac.earnMonthlyInterest() should be(5.50)
  }
}