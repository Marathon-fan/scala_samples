package example


import spray.routing.{RequestContext, Route, SimpleRoutingApp}
import akka.actor.{Props, Actor, ActorSystem}

object SprayDemo extends App with SimpleRoutingApp { //SimpleRoutingApp is production-level http server
  implicit val actorSystem = ActorSystem()

  startServer(interface = "localhost", port = 8080) {
    get {
      pathPrefix("takeaway" / "hello") {
          complete {
            "Welcome to the potato & steak take-away!"
          }
        }
      }
  }

}







// spray inside a servlet container - uses spray-routing and spray-servlet inside a Jetty server