package org.scalatra.slickexample

import org.scalatra._
import scala.xml.{Text, Node}
import scala.language.postfixOps
import org.scalatra.CorsSupport
import java.io._
import org.apache.commons._
import org.apache.http._
import org.apache.http.client._
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpDelete
import org.apache.http.impl.client.DefaultHttpClient
import java.util.ArrayList
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity

class HttpIndex extends ScalatraServlet with FlashMapSupport with CorsSupport{

  options("/*"){
    response.setHeader(
      "Access-Control-Allow-Headers", request.getHeader("http://localhost:4200"));
  }

  post("/post_delete/") {
    println("in httpIndex web/post-     delete method")
    val postId = params.get("postId") match {
      case Some(v) =>  v.toString
      case None    =>  "defaultText"
    }
    val url = "http://localhost:8080/db/api/post_delete/?postId=" +  postId
    println(url)
    val post_deleteSimulation = new HttpPost(url)
    val client = new DefaultHttpClient
    val data = client.execute(post_deleteSimulation)
    val headers = Map("Access-Control-Allow-Origin" -> "http://localhost:4200",
                    "Access-Control-Allow-Methods" -> "OPTIONS, GET, POST, PUT, DELETE, HEAD",
                    "Access-Control-Max-Age" -> "3600",
                    "Access-Control-Allow-Headers" -> "Accept, Content-Type, Origin, X-Json, X-Prototype-Version, X-Requested-With")
    Ok(data,headers) 
  }

  post("/post/") {
    println("in httpIndex web/post      post method")
    val text = params.get("text") match {
      case Some(v) =>  v.toString
      case None    =>  "defaultText"
    }
    val userId = params.get("userId") match {
      case Some(v) =>  v.toInt
      case None    =>  -1
    }
    val url = "http://localhost:8080/db/api/post/?text=" +  text + "&&userId=" + userId
    println(url)
    val post = new HttpPost(url)
    val client = new DefaultHttpClient
    val data = client.execute(post)
    val headers = Map("Access-Control-Allow-Origin" -> "http://localhost:4200",
                    "Access-Control-Allow-Methods" -> "OPTIONS, GET, POST, PUT, DELETE, HEAD",
                    "Access-Control-Max-Age" -> "3600",
                    "Access-Control-Allow-Headers" -> "Accept, Content-Type, Origin, X-Json, X-Prototype-Version, X-Requested-With")
    Ok(data,headers)
  }

  get("/posts") {
    val url = "http://localhost:8080/db/api/posts"
    val data = scala.io.Source.fromURL(url).mkString
    println("in httpIndex web/posts")    
    val headers = Map("Access-Control-Allow-Origin" -> "*",
                    "Access-Control-Allow-Methods" -> "POST, GET, OPTIONS, DELETE",
                    "Access-Control-Max-Age" -> "3600",
                    "Access-Control-Allow-Headers" -> "x-requested-with, content-type")
    Ok(data,headers)
  } 

  private def displayPage(title:String, content:Seq[Node]) = Template.page(title, content, url(_))

}
object Template {
  def page(title:String, content:Seq[Node], url: String => String = identity _, head: Seq[Node] = Nil, scripts: Seq[String] = Seq.empty, defaultScripts: Seq[String] = Seq("/assets/js/jquery.min.js", "/assets/js/bootstrap.min.js")) = {
  
  }
}
