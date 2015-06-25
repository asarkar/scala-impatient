package name.abhijitsarkar.scala.scalaimpatient.types

class DocumentProperty
object Title extends DocumentProperty
object Author extends DocumentProperty

object Then

/**
 * Q3: Complete the fluent interface in Section 18.1, "Singleton Types", so that one can call
 *
 * `book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"`
 */
class Document {
  private var title: String = null
  private var author: String = null
  private var useNextArgAs: Any = null

  def set(obj: DocumentProperty): this.type = { useNextArgAs = obj; this }

  def and(t: Then.type): this.type = this

  def to(arg: String): this.type = {
    useNextArgAs match {
      case _: Title.type => title = arg
      case _: Author.type => author = arg
    }
    this
  }

  def getTitle = title
  def getAuthor = author
}

class Book extends Document {}