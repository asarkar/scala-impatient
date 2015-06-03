package name.abhijitsarkar.scala.scalaimpatient.operators

/**
 * Q9: Define an `unapply` operation for the `RichFile` class that extracts the file path, name, and extension.
 * For example, the file `/home/cay/readme.txt` has path `/home/cay`, name `readme`, and extension `txt`.
 */
object RichFile {
  def unapply(path: String) = {
    val nameStartIdx = path.lastIndexOf('/')
    val name = path.drop(nameStartIdx + 1)

    if (!name.contains("."))
      None
    else {
      val extnStartIdx = name.lastIndexOf('.')
      Some(path.take(nameStartIdx), name.take(extnStartIdx), name.takeRight(extnStartIdx))
    }
  }
}