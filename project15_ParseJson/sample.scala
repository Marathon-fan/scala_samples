


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







//-------
你这个没有我的json复杂 哈哈哈
 Feng scala
多层嵌套  数组 map 无非就这些
 John Learner
是那个body，我感觉比较难解出来
 Feng scala
先转string 再解析
 Feng scala
你可以单独拿那个写个demo解析出来

一样的嘛  跟我的case  map是同理





