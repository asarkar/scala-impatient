package name.abhijitsarkar.scala.scalaimpatient.inheritance

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec

class BundleSpec extends UnitSpec {
  private val bundle = new Bundle
  for (i <- 1 to 3) bundle.add(new SimpleItem(i, f"Item $i%d"))

  "Bundle of 3 simple items" should "return price as the sum of individual price of items" in {
    bundle.price should be(6)
  }

  "Bundle of 3 simple items" should "return a suitable description" in {
    bundle.description should be("Item 1: Item 1; Item 2: Item 2; Item 3: Item 3")
  }
}