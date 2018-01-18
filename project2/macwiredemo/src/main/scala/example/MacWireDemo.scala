package com.softwaremill.macwire

import com.softwaremill.macwire._

// dependency injection using macwire without framework
object MacWireDemo extends  App  {

  case class Field()
  case class Digger()
  case class PotatoFarm(field: Field, digger: Digger) {
    println("New potato farm! Rejoice!") // now singleton
  }

  case class CowPasture(potatoFarm: PotatoFarm)
  case class Meatery(cowPasture: CowPasture)

  case class Restaurant(potatoFarm: PotatoFarm, meatery: Meatery) {
    def orderSteakWithPotatoes(): Unit = {
      println(s"Welcome to $this. Here's your order")
    }
  }

  trait CropModule {
    lazy val field = wire[Field]
    def potatoFarm = wire[PotatoFarm] // not singleton any more
    lazy val digger =  wire[Digger]
  }

  trait LivestockModule {
    lazy val cowPasture = wire[CowPasture]
    lazy val meatery = wire[Meatery]

    def potatoFarm: PotatoFarm
  }

  trait RestaurantModule  extends LivestockModule with CropModule {
    lazy val restaurant = wire[Restaurant]
  }

  val app = new CropModule with LivestockModule with RestaurantModule
  app.restaurant.orderSteakWithPotatoes()
}

