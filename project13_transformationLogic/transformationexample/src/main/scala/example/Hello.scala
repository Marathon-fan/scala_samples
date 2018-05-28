package example

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object Hello extends   App {

  println("Hello")

  // get value from postgreSQL
  val value1 = Future(1)
  val value2 = Future("2")
  val value3 = Future(3.0)

  val result = for {    // compose future
    one <- value1
    two <- value2
    three <- value3
  } yield {
    val result1 = transformation1(one)
    val result2 = transformation2(two)
    val result3 = transformation3(three)
    val xml =  toXML(result1, result2, result3)
    println(xml)
    // use xml to call the target decision engine
  }

  def transformation1(input:Int) = {
    val message = "transformation1"
    println(message)
    message
  }

  def transformation2(input:String) = {
    val message = "transformation2"
    println(message)
    message
  }

  def transformation3(input:Double) = {
    val message = "transformation3"
    println(message)
    message
  }

  def toXML(s1:String, s2:String, s3:String) = {
     "toXML " + value1 +" " + value2+ " " + value3
  }

}


