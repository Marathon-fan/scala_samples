




Here are the highlights of this chapter:

• An if expression has a value.
• A block has a value—the value of its last expression.
• The Scala for loop is like an “enhanced” Java for loop.
• Semicolons are (mostly) optional.
• The void type is Unit.
• Avoid using return in a function.
• Beware of missing = in a function definition.
• Exceptions work just like in Java or C++, but you use a “pattern matching” syntax for catch.
• Scala has no checked exceptions.

////////////////////////////////////////////////////
in Scala, an if/else has a value, namely the value of the expression that follows the if or else.

```
scala> def x:Int = 1;
x: Int

scala> println(if (x > 0) 100 else -100)
100


scala> val s = if (x > 0) 1 else -1
s: Int = 1


scala> println(if (x > 0) "positive" else -1)
positive


scala> println(if (x < 0) "negative" )
()



```


The type of a mixed-type expression, such as
if (x > 0) "positive" else -1
is the common supertype of both branches. In this example, one branch is a java.lang.String, and the other an Int. Their common supertype is called Any. 

in Scala, every expression is supposed to have some value. This is finessed by introducing a class Unit that has one value, written as (). The if statement without an else is equivalent to
if (x > 0) 1 else ()

Technically speaking, void has no value whereas Unit has one value that signifies “no value”. If you are so inclined, you can ponder the difference between an empty wallet and a wallet with a bill labeled “no dollars”.


////////////////////////////////////////////////////
TIP: If you want to paste a block of code into the REPL without worrying about its nearsightedness, use paste mode. Type
:paste
Then paste in the code block and type Ctrl+K. The REPL will then analyze the block in its entirety.

////////////////////////////////////////////////////



////////////////////////////////////////////////////



////////////////////////////////////////////////////


////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////
////////////////////////////////////////////////////
////////////////////////////////////////////////////
chapter2 exercises


////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////

