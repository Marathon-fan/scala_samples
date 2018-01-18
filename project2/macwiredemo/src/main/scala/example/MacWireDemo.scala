package com.softwaremill.macwire

import com.softwaremill.macwire._

// dependency injection using macwire without framework
object MacWireDemo extends  App  {

  case class Field()
  case class Digger()
  case class PotatoFarm(field: Field, digger: Digger)

  case class CowPasture()
  case class Meatery(cowPasture: CowPasture)

  case class Restaurant(potatoFarm: PotatoFarm, meatery: Meatery) {
    def orderSteakWithPotatoes(): Unit = {
      println(s"Welcome to $this. Here's your order")
    }
  }

  lazy val field = wire[Field]
  lazy val potatoFarm = wire[PotatoFarm]
  lazy val digger =  wire[Digger]

  lazy val cowPasture = wire[CowPasture]
  lazy val meatery = wire[Meatery]

  lazy val restaurant = wire[Restaurant]
  restaurant.orderSteakWithPotatoes()
}

