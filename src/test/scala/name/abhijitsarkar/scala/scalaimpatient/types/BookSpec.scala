package name.abhijitsarkar.scala.scalaimpatient.types

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class BookSpec extends UnitSpec {
  "Book" should "support fluent style calls to set title and author" in {
    val book = new Book()

    book set Title to "Scala for the Impatient" and Then set Author to "Cay Horstmann"
    
    book.getTitle should be("Scala for the Impatient")
    book.getAuthor should be("Cay Horstmann")
  }
}