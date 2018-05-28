
# getOrElse   

## map      

use a default value if the method fails, use getOrElse:

```
def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e: Exception => None
  }
}

scala> toInt("s1")
res0: Option[Int] = None


scala> val x = toInt("1").getOrElse(0)
x: Int = 1

scala> val x = toInt("s1").getOrElse(0)
x: Int = 0


```




