package name.abhijitsarkar.scala.scalaimpatient.operators

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class RichFileSpec extends UnitSpec {
  "Unapply" should "work for one path segment, name and extension" in {
    "/a/b.c" match {
      case RichFile("/a", "b", "c") => 
    }
  }
  
  "Unapply" should "work for multiple path segments, name and extension" in {
    "/a/b/c.d" match {
      case RichFile("/a/b", "c", "d") => 
    }
  }

  "Unapply" should "work for no path segment, only name and extension" in {
    "b.c" match {
      case RichFile("", "b", "c") => 
    }
  }

  "Unapply" should "not work for no extension" in {
    intercept[MatchError] {
      "b/c" match {
        case RichFile(path, name, extension) =>
      }
    }
  }
}