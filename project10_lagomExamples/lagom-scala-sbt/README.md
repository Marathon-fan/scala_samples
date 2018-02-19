
# hello-lagom


//--------------------------------

singleton Design Pattern  

Builder Design Pattern  

Factory Method  

Abstract Factory Method  


This project has been generated by the lagom/lagom-scala.g8 template. 

For instructions on running and testing the project, see https://www.lagomframework.com/get-started-scala.html.


//--------------------------------


//------  
events int the System  

```scala
trait HelloEvent extends Jsonable

object HelloEvent {
	case class GreetingMessageChanged (message: String) extends HelloEvent {
		require(message != null, "message must not be null")
	}
}

```

//------  
commands in the system  

```scala
sealed trait HelloCommand extends Jsonable 

object HelloCommand {

	case class UserGreetingMessage(message: String) extends HelloCommand with compressedJasonable with PersistentEntity.ReplyType[Done] {
		require(message != null, "message must not be null")
	}

	case class Hello(name: String, organization: Option[String]) extends HelloCommand with PersistentEntity.ReplyType[String] {
		require(name != null, "name must not be null")
		require(organization != null, "organization must not be null")
	}

}


```

//------  
State in the system 

```scala
case class WorldState (message: String, timestamp: String) extends CompressedJsonable {
	require(message != null, "message must not null")
	require(timestamp != null, "timestamp must not be null")
}

```

//------  
put command, event and state together  
```scala
class HelloWorld extends PersistentEntity[HelloCommand, HelloEvent, WorldState] {

	def initialBehavior(sanpshotState: Optional[WorldState]): Behavior = {
		var b: BehaviorBuilder = newBehaviorBuilder(snapshotState.orElse(new WorldState("hello", LocalDateTime.now.toString)))

		import scala.compat.java8.FunctionConverters._

		b.setCommandHandler[Done, UserGreetingMessage](classOf[HelloCommand.UseGreetingMessage],
			asJavaBiFunction((cmd, ctx) => ctx.thenPresist[HelloEvent](
				GreetingMessageChanged(cmd.message), asJavaConsumer((event: HelloEvent) => ctx.reply(Done.getInstance()))

				)))

	}

}


```


//--------------------------------



//--------------------------------
message-driven processing  

Message-driven processing is an approach used within the client/server computing model in which a client (for example, your Web browser) sends a service request in the form of a specially-formatted message to a program that acts as a request broker, handling messages from many clients intended for many different server applications. A message may contain the name of the service (application) wanted and possibly a requested priority or time of forwarding. The request broker manages a queue of requests (and possibly replies) and screens the details of different kinds of clients and servers from each other. Both client and server need only understand the messaging interface. 

Message-driven processing is often used in distributed computing in a geographically-dispersed network and as a way to screen new client applications from having to interact directly with legacy server applications. Special software that provides message-driven processing is known as middleware.





//--------------------------------  

```
// some kind of stateful microservice. The greeting info(first was "Hi", then was "Whatsup") can be stored in external database
GET - api/hello/Alice -> Hi Alice  
POST - api/hello/Alice {"message": "Whatsup"}  
GET - api/hello/Alice -> Whatsup Alice  

```


//--------------------------------
Jsonable(lagom)  
Jsonable(Marker interface for messages that are serialized as JSON.)  

com.lightbend.lagom.serialization
Interface Jsonable

All Superinterfaces:
java.io.Serializable
All Known Subinterfaces:
CompressedJsonable

public interface Jsonable
extends scala.Serializable

It extends java.io.Serializable to give it higher priority than JavaSerializer in Akka in case message class implements both interfaces.

//--------------------------------  
Behavior(lagom)    

com.lightbend.lagom.javadsl.persistence
Class PersistentEntity.Behavior

Behavior consists of current state and functions to process incoming commands and persisted events. Behavior is an immutable class. Use the mutable BehaviorBuilder for defining command and event handlers.


//--------------------------------
newBehaviorBuilder(lagom)  

Use newBehaviorBuilder to create a mutable builder for defining the behavior. The behavior consists of current state and functions to process incoming commands and persisted events as described in the following sections.

```scala
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

public class Post1
  extends PersistentEntity<BlogCommand, BlogEvent, BlogState> {

  @Override
  public Behavior initialBehavior(Optional<BlogState> snapshotState) {
    BehaviorBuilder b = newBehaviorBuilder(
        snapshotState.orElse(BlogState.EMPTY));

    // TODO define command and event handlers

    return b.build();
  }

}
```
The three type parameters of the extended PersistentEntity class define:

Command - the super class/interface of the commands  
Event - the super class/interface of the events  
State - the class of the state  

//--------------------------------  
Descriptor(lagom)  

A descriptor is a set of call and topic descriptors that the service provides, coupled with metadata about how the service and its calls are to be served. Metadata may include versioning and migrations, SLA's, sharding hints, circuit breaker strategies etc.


Behavior consists of current state and functions to process incoming commands and persisted events. Behavior is an immutable class. Use the mutable BehaviorBuilder for defining command and event handlers.



//--------------------------------  
Predef(scala)  

object Predef extends LowPriorityImplicits with DeprecatedPredef
The Predef object provides definitions that are accessible in all Scala compilation units without explicit qualification.

Commonly Used Types

Predef provides type aliases for types which are commonly used, such as the immutable collection types scala.collection.immutable.Map, scala.collection.immutable.Set, and the scala.collection.immutable.List constructors (scala.collection.immutable.:: and scala.collection.immutable.Nil).  

//--------------------------------  
Done(Akka)    

sealed abstract class Done extends Serializable
Typically used together with Future to signal completion but there is no actual value completed. More clearly signals intent than Unit and is available both from Scala and Java (which Unit is not).



```scala
// done source code

package akka

import java.io.Serializable
import akka.annotation.DoNotInherit

/**
 * Typically used together with `Future` to signal completion
 * but there is no actual value completed. More clearly signals intent
 * than `Unit` and is available both from Scala and Java (which `Unit` is not).
 */
@DoNotInherit sealed abstract class Done extends Serializable

case object Done extends Done {
  /**
   * Java API: the singleton instance
   */
  def getInstance(): Done = this
}

```


##  create a lagom project using scala  
https://developer.lightbend.com/start/?group=lagom&project=lagom-scala-sbt  





//--------------------------------  

```scala
case class GreetingMessage(message: String) {
	require(message != null, "message must not be null")
}
```


//--------------------------------
Model your complex domain data for scale and simplicity with CQRS and Event Sourcing


//--------------------------------
CQRS  

CQRS stands for Command Query Responsibility Segregation.  
It's a pattern that I first heard described by Greg Young. At its heart is the notion that you can use a different model to update information than the model you use to read information. For some situations, this separation can be valuable, but beware that for most systems CQRS adds risky complexity.

https://martinfowler.com/bliki/CQRS.html


//--------------------------------
Event Sourcing   

Event Sourcing pattern defines an approach to handling operations on data that's driven by a sequence of events, each of which is recorded in an append-only store. Application code sends a series of events that imperatively describe each action that has occurred on the data to the event store, where they're persisted. Each event represents a set of changes to the data (such as AddedItemToOrder).

http://microservices.io/patterns/data/event-sourcing.html  
https://docs.microsoft.com/en-us/azure/architecture/patterns/event-sourcing  