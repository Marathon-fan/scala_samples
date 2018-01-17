package example

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

import scala.concurrent.ExecutionContext.Implicits.global

object AsyncDemo  extends  App {
  val start = System.currentTimeMillis()
  def info(msg: String) = printf("%.2f: %s\n", (System.currentTimeMillis() - start) / 1000.0, msg)

  case class Dish(name: String) {
    def +(other: Dish) = Dish(s"$name with ${other.name}")
  }

  def cook(what: String): Dish = {
    Thread.sleep(1000L)
    info(s"$what cooked!")
    Dish(what)
  }

  def serve(dish: Dish): Unit = {
    info(s"Here's your ${dish.name}, sir!")
  }

  val fsteak = Future{ cook("steak") }
  val fpotatoes = Future{ cook("potatoes") }

  val fs: Future[Unit] = for {
    s <- fsteak
    p <-fpotatoes
  } yield {
    serve(s + p)
  }

  Await.result(fs, 10.seconds)

}

