
# scala

## 1 defining case classes  

Case classes are regular classes which export their constructor parameters and which provide a recursive decomposition mechanism via pattern matching.   

```
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOP(operator: String, arg: Expr) extends Expr
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
	case UnOp("-", UnOP("-", e)) => e      //double negation
	case BinOp("+", e, Number(0)) => e     // adding zero
	case BinOp("*", e, Number(1)) => e     // multiplying by one
	case _ => expr
}
```


### 

unitary | ˈjuːnɪt(ə)ri |
adjective
1 forming a single or uniform entity: a sort of unitary wholeness.

