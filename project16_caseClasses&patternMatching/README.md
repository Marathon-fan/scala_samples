
# scala

## 1 defining case classes  

Case classes are regular classes which export their constructor parameters and which provide a recursive decomposition mechanism via pattern matching.   

```
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
```

## 2 what you get: 1) a factory method   

```
scala> val v = Var("x")
v: Var = Var(x)

scala> val op = BinOp("+", Number(1), v)
op: BinOp = BinOp(+,Number(1.0),Var(x))

scala> val equation = UnOP("sin", BinOp("+", v, Number(1)))
equation: UnOP = UnOP(sin,BinOp(+,Var(x),Number(1.0)))

scala> equation.operator
res4: String = sin

scala> equation.arg
res7: Expr = BinOp(+,Var(x),Number(1.0))

//////////      
scala> case class Person(first: String, last: String, age: Int)  
defined class Person

val harry = Person("Harry", "Potter", 27)

scala> harry.first
res13: String = Harry

scala> harry.last
res14: String = Potter

scala> harry.age
res15: Int = 27
```


## 3 what you get: 3) equals/hashCode/toString     

```
scala> harry.##                // hashcode
res16: Int = -1183910746

scala> harry == Person("Harry", "Potter", 27)
res17: Boolean = true

scala> harry == Person("Harry", "Potter", 29)
res18: Boolean = false

scala> harry eq Person("Harry", "Potter", 29)
res20: Boolean = false




```


## 4 what you get: 4) copy  

1) immutable data object     

```

scala> harry.first = "Scary"
<console>:12: error: reassignment to val
       harry.first = "Scary"
                   ^

scala> harry.copy(first = "Scary")
res21: Person = Person(Scary,Potter,27)


scala> res21
res22: Person = Person(Scary,Potter,27)

scala> harry == res21
res23: Boolean = false

scala> harry.copy()
res24: Person = Person(Harry,Potter,27)

scala> harry.copy(first = "Scary", age = 37)
res25: Person = Person(Scary,Potter,37)



```

## 5 Simplifying expressions    

```scala
scala> Person
res26: Person.type = Person

scala> Person.unapply(harry)        // reduce that object to a tuple      
res27: Option[(String, String, Int)] = Some((Harry,Potter,27))

// maximum of 22 tuple size

scala> Person.tupled
res28: ((String, String, Int)) => Person = scala.Function3$$Lambda$1401/957270657@10047379

scala> ("Harry", "Potter", 27)
res29: (String, String, Int) = (Harry,Potter,27)

scala> Person.tupled(res29)
res31: Person = Person(Harry,Potter,27)


def simplifyTop(expr: Expr): Expr = expr match {
	case UnOp("-", UnOp("-", e)) => e      //double negation
	case BinOp("+", e, Number(0)) => e     // adding zero
	case BinOp("+", Number(0), e) => e     // adding zero
	case BinOp("*", e, Number(1)) => e     // multiplying by one
	case BinOp("*", Number(1), e) => e     // multiplying by one
	case _ => expr
}

scala> simplifyTop(UnOp("-", UnOp("-", Var("x"))))
res0: Expr = Var(x)

simplifyTop(BinOp("+", Number(0), UnOp("-", Var("x"))))


scala> simplifyTop(BinOp("+", Number(0), UnOp("-", Var("x"))))
res1: Expr = UnOp(-,Var(x))

scala> simplifyTop(BinOp("+", UnOp("-", Var("x")), Number(0)))
res2: Expr = UnOp(-,Var(x))


```

## 6 Wildcard patterns     

```scala
expr match {
	case BinOp("+", a, b) => println(expr + " is a binary addition")   // we can use a and b
	case BinOp("+", _, _) => println(expr + " is a binary addition")   // 
	case BinOp(_, _, _) => println(expr + " is a binary operation")
	case _ => println("it's something else")
}

```


## 7 Constant patterns     
```scala
scala> def describe(x: Any) = x match {
     |   case 5 => "five"
     |   case true => "truth"
     |   case "hello" => "hi!"
     |   case Nil => "the empty list"
     |   case _ => "something else"
     | }
describe: (x: Any)String

scala> describe(true)
res3: String = truth

scala> describe(one)
<console>:13: error: not found: value one
       describe(one)
                ^

scala> describe(1)
res5: String = something else


```

## 8 Variable patterns     

```
scala> def describe(x: Any) = 
     |    x match {
     |            case 0 => "zero"
     |            case somethingElse => "not zero: " + somethingElse
     | 
     |    }
describe: (x: Any)String

scala> 

scala> describe(0)
res6: String = zero

scala> describe(11)
res7: String = not zero: 11

```

## 9 Lower case variables, Upper case constants 

```
import math.{E, Pi}

E match {
	case Pi => "strange math ? Pi = " + Pi
	case _ => "OK"
}

```    

```
scala> E match {
     |   case pi => "strange math ? pi = " + pi
     |   case _ => "OK"
     | }
<console>:16: warning: patterns after a variable pattern cannot match (SLS 8.1.1)
       	case pi => "strange math ? pi = " + pi
                    ^
<console>:17: warning: unreachable code due to variable pattern 'pi' on line 16
       	case _ => "OK"
                         ^
<console>:17: warning: unreachable code
       	case _ => "OK"
                         ^
res9: String = strange math ? pi = 2.718281828459045


```



## 10 Constructor patterns  

```
op match {
	case BinOp("+", e, Number(0)) => println("a deep match")
	case _ => println("no match")
}

BinOp("+", e, Number(0))


```

## 11 Sequence patterns  

```
scala> def seek(x: Any) = 
     |   x match {
     |           case List(0, _, _) => println("Found it")    // has to have three items
     |           case _ =>
     |   }
seek: (x: Any)Unit

scala> 

scala> def find(x: Any) = 
     |   x match {
     |           case List(0, _*) => println("found it")      // one item or more items  
     |           case _ =>
     |   }
find: (x: Any)Unit

scala> seek(List(0, 1, 2))
Found it

scala> seek(List(0, 1, 2, 3))

scala> find(List(0, 1, 2, 3))
found it

scala> find(List(0))
found it


```




### 

### 

unitary | ˈjuːnɪt(ə)ri |
adjective
1 forming a single or uniform entity: a sort of unitary wholeness.

