package name.abhijitsarkar.scala.scalaimpatient.traits

import java.awt.Point

/**
 * Q2: Define a class `OrderedPoint` by mixing `scala.math.Ordered[Point]` into `java.awt.Point`. Use lexicographical
 * ordering, i.e. (x,y) < (x',y') if x<x' or x=x' and y<y'.
 */
class OrderedPoint extends Point with Ordered[OrderedPoint] {
  def compare(that: OrderedPoint) = (getX, getY) match {
    case _ if getX <= that.getX && getY < that.getY => -1
    case _ if getX == that.getX && getY == that.getY => 0
    case _ => 1
  }
}