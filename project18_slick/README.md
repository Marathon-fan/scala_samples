
# intro to Slick    

## why choose slick     

Option(Anorm)    orElse(Hibernate)   orElse(Slick)   

```
1 pure scala
2 Immutable data structures  
3 DB agnostic code
4 type safety

```

/////////////////////////////////////////////////////////////////////////////////////////////////////////    

1 queries: which compose using combinators suchas map,flatMap,and filter;

2 ac􏰂tions: the things you can run against a database, which themselves compose;
and

3 futures: which are the result of actions, and also support a set of combinators.




/////////////////////////////////////////////////////////////////////////////////////////////////////////    


## defining our schema    

the following class represents a row in our single example table:
```
final case class Message(
	sender: String, 
	content: String,
	id: Long = 0L
)
```

a Table object, which corresponds to our database table and tells Slick how to map back and forth between database data and instances of our case class:
The * method provides a default projec􏰃on that maps between columns in the table and instances of our case class. Slick’s mapTo macro creates a two-way mapping between the three columns and the three fields in Message.
```
final class MessageTable(tag: Tag) extends Table[Message](tag, "message") {
def id = column[Long]("id", O.PrimaryKey, O.AutoInc) 
def sender = column[String]("sender")
def content = column[String]("content")
def * = (sender, content, id).mapTo[Message] }
```

Example Queries
```
 val messages = TableQuery[MessageTable]
// messages: slick.lifted.TableQuery[MessageTable] = Rep(TableExpansion)
```

```
val halSays = messages.filter(_.sender === "HAL")
// halSays: slick.lifted.Query[MessageTable,MessageTable#TableElementType,Seq] = Rep(Filter @1367206987)
```

```
messages.schema.createStatements.mkString
// res0: String = create table "message" ("sender" VARCHAR NOT NULL,"content" VARCHAR NOT NULL,"id" BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT)
```

```
val action: DBIO[Unit] = messages.schema.create
// action: slick.jdbc.H2Profile.api.DBIO[Unit] = slick.jdbc.
JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$5@799c6fcf
```


```
 import scala.concurrent.Future
 val future: Future[Unit] = db.run(action)
// future: scala.concurrent.Future[Unit] = Future(<not completed>)
```

```
 import scala.concurrent.Await 
 import scala.concurrent.duration._
 val result = Await.result(future, 2.seconds) 
 // result: Unit = ()
```


Selec􏰀ng Data
```
val messagesAction: DBIO[Seq[Message]] = messages.result

val messagesFuture: Future[Seq[Message]] = db.run(messagesAction)

val messagesResults = Await.result(messagesFuture, 2.seconds)

```

Introduce a helper method called exec to make the examples easier to read:
```
def exec[T](action: DBIO[T]): T = Await.result(db.run(action), 2.seconds)
// exec: [T](action: slick.jdbc.H2Profile.api.DBIO[T])T
```

```
messages.filter(_.sender === "HAL").result.statements.mkString
// res3: String = select "sender", "content", "id" from "message" where "sender " = 'HAL'
```

```
exec(messages.filter(_.sender === "HAL").result)
// res4: Seq[MessageTable#TableElementType] = Vector(Message(HAL,Affirmative,
Dave. I read you.,2), Message(HAL,I'm sorry, Dave. I'm afraid I can't do that.,4))
```

///////////////////////////////////////////////////  
Combining Queries with For Comprehensions


Remember that for comprehensions are aliases for chains of method calls. 
```
val halSays2 = for {
message <- messages if message.sender === "HAL"
} yield message
// halSays2: slick.lifted.Query[MessageTable,Message,Seq] = Rep(Bind)
```



/////////////////////////////////////////////////////////////////////////////////////////////////////////


## slick real example     





```scala
    val dbSFTestConnection = Connections.getSaleForceSchemaDBObject().db

    val assetAndLiabilityQuery = AssetAndLiabilities.filter(al => al.opportunity_C === request.body.Opportunity__c_al).map(
      x => (x.account_C, x.accountName_C, x.address_C, x.recordtypeid, x.state_C))

    val result_assetAndLiabilityQuery = dbSFTestConnection.run(assetAndLiabilityQuery.result)
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration._
    Await.result(result_assetAndLiabilityQuery, 10.seconds)
    println("--==--==--=--==--==-==--==--==--==begin to print result_assetAndLiabilityQuery")
    result_assetAndLiabilityQuery.map { data => {
      val dataList = data.toList
      dataList.map(item => {
        val output = item match{
          case (v1, v2, v3, v4, v5) => {
            println(v1)
            println(v2)
            println(v3)
            println(v4)
            println(v5)
            println("---------------")
          }
        }
      })
     }
    }

```


## Build queries with Scala - lifted embedding     


## database specific   
```
import scala.slick.driver.H2Driver.simple._


Database.forURL(
	"jdbc:postgresql://localhost:5432/meeting",
	driver = "org.postgresql.Driver"
) withSession {
	implicit session =>
	// queries
}



Database.forURL(
	"jdbc:postgresql://localhost:5432/meeting",
	driver = "org.postgresql.Driver"
) withTransaction {
	implicit session =>
	// queries
} // like for multiple inserts, then if one fail, it will rollback


```




## sample databases    

```
                meeting-------------------------
                |                              | 
                |                              |
                |                              |
             document                        attendee_LINK
              meeting_ID                       meeting_ID
                                               |
                                               |
                                              Attendee   

```     

## level 1: Mapping Tables   

```
object MeetingModel {
	case class Meeting(
		               id: Option[Long] = None,
		               title: String,
		               summary: Option[String],
		               location: Option[String],
		               startTime: DataTime,
		               endTime: DateTime,
		               ownerId: Long
		               )

	class Meeting(tag: Tag) extends Table[Meeting] (tag, "meeting") {
	//Tag represents a table row 
	  def id = column[Long]("id", 0.PrimaryKey, 0.AutoInc)
	  def title = column[String]("title")
	  def summary = column[Option[String]]("summary")
	  def location = column[Option[String]]("location")
	  def startTime = column[DateTime]("start_time")
	  def endTime = column[DateTime]("end_time")
	  def ownerId = column[Long("owner_id")]
	  def * = (id.?, title, summary, location, startTime, endTime, ownerId)
	     <> (Meeting.tupled, Meeting.unapply)
	  // star function represents the default porjection when you perform a query on database
	  //  
    }

	val meetings = TableQuery[Meetings]
	// meetings is a table which can execute query  
}

```


```
object AttendeeLinkModel {
	case class AttendeeLink(
		  id: Option[Long] = None,
		  meetingId: Long,
		  attendeeId: Long
		)

	class AttendeeLinks(tag: Tag)
	    extends Table[AttendeeLink] (tag, "attendee_link") {
	    	val id = column[Long]("id", 0,PrimaryKey, 0.AutoInc)
	    	val meetingId = column[Long]("meeting_id")
	    	val attendeeId = comumn[Long] ("attendee_id")
	    	def * = (id.?, meetingId, attendeeId) 
	    	   <> (AttendeeLink.tupled, AttendeeLink.unapply)
	    }	
	val attendeeLinks = TableQuery[AttendeeLinks]
}

```

## level 2: Basic Queries   

------------------------------------------select   
slick
``` 
meetings.where(_.ownerId === 1L).list
```

in slick, use === instead of ==  
use =? instead of != 


SQL
```
select * from meeting where owner_id = 1
```

------------------------------------------select    
slick
```
users.where {
	user =>
	 (user.firstName.toLowerCase link "%someText%") || 
	 (user.lastName.toLowerCase link "%someText%")
}.list
```


------------------------------------------sorting    

slick
```
meetings.sortBy(_.startTime.desc).list

```
SQL
```
select * from meeting order by meeting.start_time desc
```

------------------------------------------exist    
slick
```
Query(
	meetings.where(_.location === "Antwerp").exists
).first
```
first return the first result   


SQL
```
select exists(
	select * from meeting where meeting.location = 'Antwerp'
)
```

------------------------------------------select all   
Slick
```
meeting.list
``` 

SQL
```
select * from meeting
```

Result
```
List[Meeting]
```

------------------------------------------select a couple of columns  
Slick
```
meeting.map( meeting =>
	(meeting.id, meeting.location)
).list
``` 

SQL
```
select id, location from meeting
```

Result
```
List[(Long, Option[String])]
```

------------------------------------------short summary    
meetings.list                 list[Meeting]

meetings.first                meeting or NoSuchElementException

meetings.firstOption          Option[Meeting]

## level 3: Advanced Queries   

------------------------------------------inner join  
Slick
```
meeting.innerJoin(documents).on {
	case (meeting, document) => 
	   meeting.id === document.meetingId
}.where {
	case (meeting, document) =>
	meeting.id === 1L
}.list
``` 


SQL
```
select * from meeting inner join documents
    on meeting.id = documents.meeting_id
    where meeting.id = 1
```

Result
```
List[(Meeting, Document)]
```

------------------------------------------    

Slick
```
meeting.innerJoin(documents).on {
	...
}.where {
	...
}.mapResult {
	case (meeting, document) =>
	  meeting.documents = Some(Set(document))
	  meeting
}.list.reduceOption {
	(previousMeeting, meeting) =>
	   previousMeeting.documents = 
	      Some(previousMeeting.documents.get ++ meeting.document.get)
	   previousMeeting 

}
``` 

Result
```
Option[Meeting]
```




