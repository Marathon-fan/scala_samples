


JSON.parseFull(result) match {
                  case Some(json: Map[String, Any]) =>
                    val arr = json.get("results")
                    if (arr.isDefined) {
                      val expArr = arr match {
                        case Some(list: List[Map[String, Any]]) => list
                        case _ => Nil
                      }
                      expArr.foreach { exp =>
                        val firstRunTime = exp.get("first_experiment_start") match {
                          case Some(value) => BigDecimal.exact(value.toString).toLong
                          case _ => 0l
                        }
                        if (firstRunTime >= from_time && firstRunTime <= to_time) {
                          val email = exp.get("account") match {
                            case Some(value) => URLDecoder.decode(value.toString, "UTF-8")
                            case _ => ""
                          }
                          if (email.nonEmpty) {
                            accessUserEmail = email :: accessUserEmail
                          }
                        }
                      }
                    }
                  case _ =>

                }



//---error info circe 

Well, specifically a failed downField would indicate a missing field.

//---

scala TupleDecoders  !!!

//---
Implicit JSON conversion with Scala

http://lollyrock.com/articles/scala-implicit-conversion/

//---

import cats.instances.either._
import cats.syntax.cartesian._
import io.circe._, io.circe.parser._, io.circe.syntax._

case class NestedClass(id: Long, displayName: String, nesting: Option[NestedClass])

object NestedClass {
  implicit val nestedClassDecoder: Decoder[NestedClass] = Decoder.instance { c =>
    (
      c.get[Long]("id") |@|
      c.get[String]("display_name") |@|
      c.get[Option[NestedClass]]("nesting")
    ).map(NestedClass.apply)
  }

  implicit val nestedClassEncoder: Encoder[NestedClass] = Encoder.instance {
    case NestedClass(i, d, n) => Json.obj(
      "id"           -> i.asJson,
      "display_name" -> d.asJson,
      "nesting"      -> n.asJson
    )
  }

      val testString =
      """
        |{
        |  "id": 10000,
        |  "display_name": "foobar",
        |  "nesting": {
        |    "id": 10001,
        |    "display_name": "quux"
        |  }
        |}
      """.stripMargin



}

/////////////////////////////////////////
case class Foo(firstName: String, lastName: String, age: Int, stuff: List[Boolean])





////////////////////////////////////////


//-------
多层嵌套  数组 map 无非就这些
是那个body，我感觉比较难解出来
先转string 再解析
可以单独拿那个写个demo解析出来
跟我的case  map是同理





