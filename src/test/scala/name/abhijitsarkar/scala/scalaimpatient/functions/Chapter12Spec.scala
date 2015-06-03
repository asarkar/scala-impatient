package name.abhijitsarkar.scala.scalaimpatient.functions

import name.abhijitsarkar.scala.scalaimpatient.UnitSpec
import Chapter12.unless 
import Chapter12.unless2

class Chapter12Spec extends UnitSpec {
  "Method unless" should "behave like an inverse if" in {
    var condition = () => false
    val block = true
    
    unless(condition, block) == true
    
    condition = () => true
    
    unless(condition, block) == false
  }
  
  "Method unless2" should "behave like an inverse if" in {
    val block = true
    
    unless2(false) { block } == true
    
    unless2(true) { block } == false
  }
}