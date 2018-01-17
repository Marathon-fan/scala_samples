package example

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

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

  import scala.async.Async._

  def wantsRice() = Future { Thread.sleep(500L); Random.nextBoolean() }

  val fs = async {
    val fsteak = async { cook("steak") }
    val fpotatoes = async { cook("potatoes") }

    if (await(wantsRice())) {
      val rice = async { cook("rice") }
      serve( await(fsteak) + await(rice))

    } else {
      serve( await(fsteak) + await(fpotatoes))
    }
  }

  Await.result(fs, 10.seconds)
}

