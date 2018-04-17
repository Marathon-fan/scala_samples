package example

object Hello extends Greeting with App {

  println(greeting)
  WeekDay.values.filter(x => WeekDay.isWorkingDay(x)).foreach(println)  
}

trait Greeting {
  lazy val greeting: String = "hello"
}

object WeekDay extends Enumeration {
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value

def isWorkingDay(d: WeekDay) = {!(d == Sat || d == Sun)}

}
