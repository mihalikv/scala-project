import scala.collection.mutable.ListBuffer
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by Viliam on 17.10.2017.
  */
object Concurrency extends App {
    def sha256Hash(text: String): String = String.format("%064x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("SHA-256").digest(text.getBytes("UTF-8"))))

    def getHashes: List[String] = {
        var result: ListBuffer[String] = new ListBuffer[String]()
        1 to 1000 foreach {
            _ => result += sha256Hash("test")
        }
        result.toList
    }

    val future: Future[List[String]] = Future {
        getHashes
    }
    future.onComplete {
        case Success(hashes) => for (hash <- hashes) println(hash)
        case Failure(t) => println("An error has occured: " + t.getMessage)
    }

    println(s"Bla bla bla")
    Await.result(future, 1 microseconds)
}
