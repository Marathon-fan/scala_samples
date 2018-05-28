
# Some None Option 


## Some None Option    
Some   
Class Some[A] represents existing values of type A    

None   
Case Object None represents non-existent values  

Option
Instances of Option are either an instance of scala.Some or the Object None   
Option(x) evaluates x and returns Some(x) on not-null input, and None on null input  
use Option(x) when not sure whether x can be null or not   
use Some(x) when 100% sure x is not null  


## example     

```
def toInt(in: String): Option[Int] = {
	try {
		Some(Integer.parseInt(in.trim))
	} catch {
		case e: NumberFormatException => None
	}
}
```

then we use the following code to test this function

```
val s1 = "154"
val s2 = "232S"

toInt(s1) match {
	case Some(i) => println(i)
	case None => println("That did'nt work")
}

toInt(s2) match {
	case Some(i) => println(i)
	case None => println("That didn't work")
}


```



