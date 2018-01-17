# scala

## 1 how to initialize a scala project  
http://www.scala-sbt.org/0.13/docs/Hello.html


## 2 how to run it  
1) $> cd project1/project2/project3  
2) $> sbt  
3) $> run  


## x scala basics  
1) object  
In Scala, we cannot have static members. Instead, Scala has singleton objects. A singleton is a class that can have only one instance, i.e., Object. You create singleton using the keyword object instead of class keyword.  


```scala
object Demo {
   def main(args: Array[String]) {
      val point = new Point(10, 20)
      printPoint

      def printPoint{
         println ("Point x location : " + point.x);
         println ("Point y location : " + point.y);
      }
   }
}
```



