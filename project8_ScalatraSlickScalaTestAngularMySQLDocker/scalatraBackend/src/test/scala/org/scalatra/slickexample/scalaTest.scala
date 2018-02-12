import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest._
import org.scalatest.Matchers._

import slick.jdbc.MySQLProfile.api._
import slick.driver.{JdbcProfile, MySQLDriver}
import slick.driver.MySQLDriver.api._ 

import com.mchange.v2.c3p0.ComboPooledDataSource

import org.scalatra.slickexample._

import scala.concurrent._
import scala.concurrent.duration.Duration
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global

import java.util.Calendar

class scalaTest extends FunSpec with BeforeAndAfter {

  var driver: JdbcProfile = _
  var db: slick.driver.MySQLDriver.backend.DatabaseDef = _ 
  var app: SlickApp = _

  before {      
    driver = MySQLDriver // Create a database connection
    db = Database.forURL("jdbc:mysql://localhost:3306/scalatra_test", "root", "root")
    db.createSession()
    app = new SlickApp();
  }

  describe("database") {
    // connect to the database and show tables  
    it("should allow connection to the database") {
      db.run(sql"""show tables""".as[String]) map {
      data => 
      val s = data.toString
      s should include ("User")
      s should include ("Post")
      }
    }  
  }


  //connect to the database and find posts  
//   describe("users") {
//     it("should allow show the posts") {
//         val url = "http://localhost:8080/db/api/posts"
//         val data = scala.io.Source.fromURL(url).mkString
//         data should include ("postId")  
//     }  
//   }
  

}


