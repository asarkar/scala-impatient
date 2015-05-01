package name.abhijitsarkar.scala.scalaimpatient.classes

/**
 * Q2: Write a class `BankAccount` with methods `deposit` and `withdraw`, and a read-only property `balance`.
 */
/* Compiler generates private getter and setter */
class BankAccount(private var balance: Double) {
  def deposit(amount: Double) = { balance += amount; balance }

  def withdraw(amount: Double) = { balance -= amount; balance }
}