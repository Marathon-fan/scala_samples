package example

import akka.actor.{ ActorRef, ActorSystem, Props, Actor }
import scala.concurrent.duration._

case class WhoToGreet(who: String)

class Greeter extends Actor {
    def receive = {
        case WhoToGreet(who) => println(s"Hello $who")
    }
}


object Hello extends  App {
    val system = ActorSystem("Hello-Akka")

    val greeter = system.actorOf(Props[Greeter], "greeter")

    greeter ! WhoToGreet("Akka")
}



