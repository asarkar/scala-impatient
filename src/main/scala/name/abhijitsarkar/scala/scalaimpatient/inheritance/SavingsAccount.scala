package name.abhijitsarkar.scala.scalaimpatient.inheritance

import java.math.MathContext
import java.math.RoundingMode.HALF_UP

import scala.BigDecimal

/**
 * Q2: Extend the `BankAccount` class of the preceding exercise into a class `SavingsAccount` that earns interest
 * every month (when a method `earnMonthlyInterest` is called) and has three free deposits or withdrawals every month.
 * Reset the transaction count in the `earnMonthlyInterest` method.
 */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private val numFreeTxn = 3
  private val txnFee = 1.0d
  private val interestRate = 0.06
  private val mathCtx = new MathContext(2, HALF_UP)

  private var transactionCount = 0;

  override def deposit(amount: Double) = {
    transactionCount += 1

    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    transactionCount += 1

    super.withdraw(amount)
  }

  def earnMonthlyInterest() = {
    super.withdraw(txnFee * ((transactionCount - numFreeTxn) max 0))

    transactionCount = 0

    val interest = currentBalance * (1 + interestRate / 12) - currentBalance

    BigDecimal(interest, mathCtx).rounded.doubleValue
  }
}