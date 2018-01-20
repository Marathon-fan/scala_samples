package example


import spray.routing.{RequestContext, Route, SimpleRoutingApp}
import akka.actor.{Props, Actor, ActorSystem}

object SprayDemo extends App with SimpleRoutingApp { //SimpleRoutingApp is production-level http server
  implicit val actorSystem = ActorSystem()

  // type Route = RequestContext => Unit

  startServer(interface = "localhost", port = 8080) {
    get {

      //  curl "http://localhost:8080/takeaway/hello"
      path ("takeaway" / "hello") {
          complete {
            "Welcome to the potato & steak take-away!"
          }
        }
      } ~

    //  curl "http://localhost:8080/order/potatoes?mashed=false&number=10&special=baked"
    path("order" / "potatoes") {
        parameters("mashed".as[Boolean], "number".as[Int], "special"?) {   // special is an optional parameter
          (mashed, number, special) =>
            complete {
              s"You have orderd ${mashed} potatoes, ${number + 1} (one is free)" + s"Special wishes: ${special.getOrElse("none")}"
            }

        }
      }

  }

}







// spray inside a servlet container - uses spray-routing and spray-servlet inside a Jetty server