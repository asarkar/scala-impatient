package name.abhijitsarkar.scala.scalaimpatient.maps

import org.scalatest.FlatSpec

class Chapter4Spec extends FlatSpec {
  private val ch4 = new Chapter4()
  
  "discountedGizmos method" should "reduce all prices by 10%" in {
    val gizmos = Map("Leica M9" -> 4950.00, "Hasselblad H5D-200c" -> 45000.00)
    
    val discountedGizmos = ch4.discountGizmos(gizmos)
    
    assert(discountedGizmos("Leica M9") == 4950.00 - 4950.00 * 0.9)
    assert(discountedGizmos("Hasselblad H5D-200c") == 45000.00 - 45000.00 * 0.9)
  }
  
} 