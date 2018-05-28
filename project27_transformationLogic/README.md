
# program skeleton for database transformation        

suppose we use slick read different types of data from database
```scala
  val value1 = Future(1)
  val value2 = Future("2")
  val value3 = Future(3.0)
```

then we call a transformation layer to deal with the data so that it can be formatted

```scala
 def transformation1(input:Int) = {
    val message = "transformation1"
    println(message)
    message
  }
...
  def toXML(s1:String, s2:String, s3:String) = {
     "toXML " + value1 +" " + value2+ " " + value3
  }

```

at last, we use xml to call the target decision engine 

```
use xml to call the target decision engine
```


In the process, we compose the future
```
  val result = for {    // compose future
    one <- value1
    two <- value2
    three <- value3
  } yield {
    val result1 = transformation1(one)
    val result2 = transformation2(two)
    val result3 = transformation3(three)
    val xml =  toXML(result1, result2, result3)
    println(xml)
  }
    // use xml to call the target decision engine

```
