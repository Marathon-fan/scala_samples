
# Future    


Using the apply method of a companion object is a common Scala idiom for con- structing objects. For example, Array(1, 4, 9, 16) returns an array, thanks to the apply method of the Array companion object.


```scala
in the documentation of the StringOps class, you will find a method
def apply(n: Int): Char

That is, "Hello"(4) is a shortcut for

"Hello".apply(4)
```



When you look at the documentation for the BigInt companion object, you will see apply methods that let you convert strings or numbers to BigInt objects. For example, the call
```scala
BigInt("1234567890")
is a shortcut for
BigInt.apply("1234567890")

scala> BigInt("1234567890") * BigInt("435345431234567890")
res2: scala.math.BigInt = 537463490460400575019052100

scala> BigInt.apply("1234567890") * BigInt.apply("478631315464")
res3: scala.math.BigInt = 590902853220314850960



```


