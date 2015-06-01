package name.abhijitsarkar.scala.scalaimpatient.operators

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class RichFileSeqSpec extends UnitSpec {
  "Unapply seq" should "work for multiple path segments and name" in {
    "/a/b/c.d" match {
      case RichFileSeq("a", "b", "c.d") =>
    }
  }

  "Unapply seq" should "work for one path segment and name" in {
    "a/c.d" match {
      case RichFileSeq("a", "c.d") =>
    }
  }
  
  "Unapply seq" should "work for no path segment, only name" in {
    "c.d" match {
      case RichFileSeq("c.d") =>
    }
  }
  
  "Unapply seq" should "not work for no extension" in {
    intercept[MatchError] {
      "b/c" match {
        case RichFile(path, name, "") =>
      }
    }
  }
}