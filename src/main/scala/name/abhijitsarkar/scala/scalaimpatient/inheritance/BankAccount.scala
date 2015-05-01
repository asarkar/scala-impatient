package name.abhijitsarkar.scala.scalaimpatient.inheritance

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount:Double) = { balance -= amount; balance }
}