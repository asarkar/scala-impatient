package name.abhijitsarkar.scala.scalaimpatient.operators

/**
 * Q10: Define an `unapplySeq` operation for the `RichFile` class that extracts all path segments.
 * For example, the file `/home/cay/readme.txt` you should produce a sequence of three segments: `home`, `cay` and 
 * `readme.txt`.
 */
object RichFileSeq {
  def unapplySeq(path: String): Option[Seq[String]] = {
    val nameStartIdx = path.lastIndexOf('/')
    val name = path.drop(nameStartIdx + 1)

    if (!name.contains("."))
      None
    else {
      /* The filter is to weed out an empty segment that's created if the path starts with '/' */
      Some(path.take(nameStartIdx).split("/").filterNot(_.isEmpty) ++ Array(name))
    }
  }
}