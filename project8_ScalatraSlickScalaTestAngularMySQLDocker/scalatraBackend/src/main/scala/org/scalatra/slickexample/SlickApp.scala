package org.scalatra.slickexample

import org.scalatra.{ScalatraBase, FutureSupport, ScalatraServlet}

import slick.jdbc.MySQLProfile.api._
import slick.driver.{JdbcProfile, MySQLDriver}
import slick.driver.MySQLDriver.api._

import play.api.libs.json._

import scala.concurrent._
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import org.scalatra.CorsSupport


object Tables {

  // Definition of the  table
  class User(tag: Tag) extends Table[(Int, String, String)](tag, "User") {
    def userId = column[Int]("userId", O.PrimaryKey) // This is the primary key column
    def userName = column[String]("userName")
    def password = column[String]("password")
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (userId, userName, password)
  }

  // Definition of the  table
  class Post(tag: Tag) extends Table[(Int, String, Int)](tag, "Post") {
    def postId = column[Int]("postId", O.PrimaryKey)
    def text = column[String]("text")
    def userId = column[Int]("userId")
    def * = (postId, text, userId)
  }

  // Table query for the  table, represents all tuples
  val users = TableQuery[User]

  // Table query for the table
  val posts = TableQuery[Post]

  // Query
  var findUsers = {
    for {
      u <- users
    } yield (u.userName, u.userId)
  }

  var findPosts = {
    for {
      p <- posts
    } yield (p.postId, p.userId, p.text)
  }

  // DBIO Action which creates the schema
  val createSchemaAction = (users.schema ++ posts.schema).create

  // DBIO Action which drops the schema
  val dropSchemaAction = (users.schema ++ posts.schema).drop

  // Create database, composing create schema and insert sample data actions
  //val createDatabase = DBIO.seq(createSchemaAction, insertUserAndPostData)
  val createDatabase = DBIO.seq(createSchemaAction)
}

trait SlickRoutes extends ScalatraBase with FutureSupport {

  def insertUser(userName:String,  userPass:String): DBIO[Int] = 
    sqlu"insert into User (userId, userName, password) values (DEFAULT, ${userName}, ${userPass})"

  def deleteUser(userId:Int): DBIO[Int] = 
    sqlu"delete from User where userId = ${userId}" 

  def insertPost(text:String,  userId:Int): DBIO[Int] = 
    sqlu"insert into Post (postId, text,  createdAt, userId) values (DEFAULT, ${text}, NOW(), ${userId})"

  def deletePost(postId:Long): DBIO[Int] = 
    sqlu"delete from Post where postId = ${postId}" 

  def userAllPosts(userId:Int) = 
    sql"select * from Post where userId = ${userId}".as[(String, String, String, String)]

  def  allPosts() = 
    sql"select * from Post".as[(String, String, String, String)]

  // Create a database connection
  val driver: JdbcProfile = MySQLDriver
  val db = Database.forURL("jdbc:mysql://mysql:3306/scalatra_test", "root", "root")
  //val db = Database.forURL("jdbc:mysql://localhost:3306/scalatra_test", "root", "root")

  db.createSession()

  // code for testing the db   
  //db.run(sql"""show databases""".as[String])     //show all the databases
  //db.run(sql"""show tables""".as[String])        //show all the tables in current database

  // add a user 
  post("/api/user/") {
    println(params)
    val newUserName = params.get("username") match {
      case Some(v) =>  v.toString
      case None    =>  "defaultUserName"
    }
    val newUserPass = params.get("password") match {
      case Some(v) =>  v.toString
      case None    =>  "defaultPassword"
    }
    println(newUserName)
    println(newUserPass)
    db.run(
        insertUser(newUserName, newUserPass)
    )
  }

  // delete a user 
  delete("/api/user/") {
    println(params)
    val userId = params.get("userId") match {
      case Some(v) =>  v.toInt
      case None    =>  -1
    }
    println(userId)
    db.run(
        deleteUser(userId)
    )
  }

  // get all users
  get("/api/users") {
    //println(db.getClass)

    db.run(Tables.findUsers.result) map { res =>
      println(res)
      res
    }
  }

  // show a users' all posts
  get("/api/userPosts/") {
    println(params)
    val userId = params.get("userId") match {
      case Some(v) =>  v.toInt
      case None    =>  -1
    }
    db.run(
        userAllPosts(userId) map { res =>
          println(res)
          res
    })  
  }


  // add a post 
  post("/api/post/") {
    println(params)
    val text = params.get("text") match {
      case Some(v) =>  v.toString
      case None    =>  "defaultText"
    }
    val userId = params.get("userId") match {
      case Some(v) =>  v.toInt
      case None    =>  -1
    }
    println(text)
    println(userId)

    db.run(
        insertPost(text, userId)
    )
  }

  // delete a post 
  post("/api/post_delete/") {  // use post to simulate post method(to delete a post)
    println(params)
    val postId = params.get("postId") match {
      case Some(v) =>  v.toLong
      case None    =>  -1
    }
    println(postId)
    db.run(
        deletePost(postId)
    )
  }

  case class _Post(postId: Long, text: String, userId: Int)
  implicit val _PostFormat = Json.format[_Post]

  get("/api/posts")  {
    val listBuffer = new ListBuffer[JsValue]()
    db.run(
        allPosts() map { data =>
        for (line <- data) {
          listBuffer += Json.toJson(new _Post(line._1.toLong, line._2, line._4.toInt)) 
        }
        println(listBuffer)
        Json.toJson(listBuffer)        
    })  
  }
}

class SlickApp() extends ScalatraServlet with FutureSupport with SlickRoutes {

  options("/*"){
    response.setHeader(
      "Access-Control-Allow-Headers", request.getHeader("http://localhost:4200"));
  }

  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

}
