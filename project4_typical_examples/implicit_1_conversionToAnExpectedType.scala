
scala> val i: Int = 5
i: Int = 5

scala> val i: Int = 3.5
<console>:11: error: type mismatch;
 found   : Double(3.5)
 required: Int
       val i: Int = 3.5
                    ^

scala> implicit def doubleToInt(x: Double) = x.toInt
<console>:11: warning: implicit conversion method doubleToInt should be enabled
by making the implicit value scala.language.implicitConversions visible.
This can be achieved by adding the import clause 'import scala.language.implicitConversions'
or by setting the compiler option -language:implicitConversions.
See the Scaladoc for value scala.language.implicitConversions for a discussion
why the feature should be explicitly enabled.
       implicit def doubleToInt(x: Double) = x.toInt
                    ^
doubleToInt: (x: Double)Int

scala> val i: Int = 3.5
i: Int = 3

scala> 


