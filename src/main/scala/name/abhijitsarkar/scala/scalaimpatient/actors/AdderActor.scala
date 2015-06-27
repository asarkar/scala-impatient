package name.abhijitsarkar.scala.scalaimpatient.actors

import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.pattern.ask
import akka.util.Timeout

case class Add(input: Seq[Int])

class AdderActor extends Actor {
  def receive = {
    case Add(v) => println(f"Actor called with ${v}%s running in thread ${Thread.currentThread().getName}%s"); sender ! v.sum
  }
}

object Calculator {
  def average(n: Int): Double = {
    val system = ActorSystem("ActorSystem")
    val myActor = system.actorOf(Props[AdderActor], name = "adderActor")
    implicit val timeout = Timeout(1 seconds)

    val values = for (i <- 1 to n) yield i

    val sums = values.grouped(2).map { seq => myActor ? Add(seq) }.toList

    sums.foldLeft(0) { (acc, future) =>
      acc + Await.result(future, timeout.duration).asInstanceOf[Int]
    } / n.toDouble
  }
}

