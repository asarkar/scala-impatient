package name.abhijitsarkar.scala.scalaimpatient.actors

import java.io.File
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.io.Source
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.pattern.ask
import akka.util.Timeout
import akka.actor.ActorLogging
import akka.actor.OneForOneStrategy
import java.io.IOException
import akka.actor.SupervisorStrategy.Stop
import scala.util.Random
import scala.concurrent.Future

/* http://doc.akka.io/docs/akka/snapshot/scala/actors.html */
class SubdirActor extends Actor {
  def receive = {
    case dir: File => {
      println(f"${this.getClass.getName} called with ${dir.getName} running in thread ${Thread.currentThread().getName}")

      val allFiles = dir.listFiles.filter(_.isFile).toList

      sender ! allFiles
    }
  }
}

case class Data(dir: File, word: String)
case object BlowUp

class WordCountActor extends Actor {
  def receive = {
    case Data(f, word) => {
      println(f"${this.getClass.getName} called with file ${f.getName} and word $word running in thread ${Thread.currentThread().getName}")

      val count = Source.fromFile(f).getLines.filter { _.contains(word) }.length

      sender ! count
    }

    case BlowUp => throw new IOException("Not my fault")
  }
}

class AggregratorActor extends Actor {
  import context._

  val subdirActor = actorOf(Props[SubdirActor], "subdirActor")
  val wordCountActor = actorOf(Props[WordCountActor], "wordCountActor")

  /* https://dzone.com/articles/akka-notes-actor-supervision */
  override val supervisorStrategy = OneForOneStrategy() {
    case _: IOException => {
      println("The exception from the WordCountActor is now handled by the AggregratorActor.")
      Stop
    }
  }

  def receive = {
    case Data(dir, word) => {
      println(f"${this.getClass.getName} called with ${dir.getName} running in thread ${Thread.currentThread().getName}")

      implicit val timeout = Timeout(1 seconds)

      // Another way to send messages
      val allFilesFuture = subdirActor ask dir

      val allFiles = Await.result(allFilesFuture, timeout.duration).asInstanceOf[List[File]]

      val wordCountFutures = allFiles.map { aFile => wordCountActor ? Data(aFile, word) }

      val wordCount = wordCountFutures.foldLeft(0) { (acc, wordCountFuture) =>
        acc + Await.result(wordCountFuture, timeout.duration).asInstanceOf[Int]
      }

      sender ! wordCount
    }
    case BlowUp => {
      implicit val timeout = Timeout(1 seconds)

      wordCountActor ? BlowUp

      sender ! -1
    }
  }
}

/**
 * Q3: Write a program that counts how many words match a given regular expression in all files of all subdirectories
 * of a given directory. Have one actor per file, one actor that traverses the subdirectories, and one actor to
 * accumulate the results.
 * 
 * Q7: Add a supervisor to the program of exercise 3 the monitors the file reading actors and logs any that exit with 
 * an `IOException`.
 */

object WordCounter {
  def countWords(dir: File, word: String, blowUp: Boolean = false): Int = {
    val system = ActorSystem("ActorSystem")

    val aggregratorActor = system.actorOf(Props[AggregratorActor], name = "aggregratorActor")

    implicit val timeout = Timeout(1 seconds)

    var wordCountFuture: Future[Any] = null

    if (blowUp) {
      wordCountFuture = aggregratorActor ? BlowUp

      Await.result(wordCountFuture, timeout.duration).asInstanceOf[Int]
    } else {
      wordCountFuture = aggregratorActor ? Data(dir, word)

      Await.result(wordCountFuture, timeout.duration).asInstanceOf[Int]
    }
  }
}