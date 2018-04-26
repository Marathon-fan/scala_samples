

implicit def function2ActionListener(f: ActionEvent => Unit) =
      new ActionListener {
        def actionPerformed(event: ActionEvent) = f(event)
      }

////////////////
1 "implicit conversion" is a function      
2 in last example, it takes an function as the input, and returns an object with a function inside

////////////////

Now we can call function2ActionListener:

button.addActionListener (
  function2ActionListener (
    (_: ActionEvent) => println("pressed!")
  )
)

//////////////// or we just use


button.addActionListener(
  (_: ActionEvent) => println("pressed!")
)
////////////////////////////////////////////////////////////////rules for implicits
1 marking rule: only definitions marked implicit are available 

implicit def intToString(x: Int) = x.toString

2 scope rule: an inserted implicit conversion must be in scope as a single identifier, or be associated with the source or target type of the conversion

// this is an exception
object Dollar {
  implicit def dollarToEuro(x: Dollar): Euro = ...
}
class Dollar {...}

3 One-at-a-time rule: Only one implicit is inserted

4 Explicits-first rule: Whenever code type checks as it is written, no implicits are attempted  


////////////////////////////////////////////////////////////////naming an implicit conversion  

the name of an implicit conversion matters in the following situations:


////////////////////////////////////////////////////////////////three places implicits are used in the language   

1 conversions to an expected type  
for example, you might have a String and want to pass it to a method that requires an IndexedSeq[Char]

2 conversions of the recevier of a selection  
for example, "abc".exists  will be converted into stringWrapper("abc").exists

3 implicit parameters  



////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////


