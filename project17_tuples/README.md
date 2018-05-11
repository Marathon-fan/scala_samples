
# scala

## 1 Tupled to pass tuples to functions in Scala


Tupled to pass tuples to functions in Scala
When using tuples within Scala the tuple function can be use to convert a function which takes multiple parameters to accept just the tuple keeping the code more concise.

```
object ApplyFunctionToATuple {

  def addition(a: Int, b: Int) = a + b

  val pairOfNumbers = (1, 2)
  addition(pairOfNumbers._1, pairOfNumbers._2) // Extract values and apply
  Function.tupled(addition _)(pairOfNumbers) // Scala 2.7 version
  (addition _).tupled(pairOfNumbers) // Scala 2.8 version
}
```

