
# Future    


A possible approach is awaiting the result, but it is not good to use in a prod application.
```scala
val myFutureResult : Future[T] = Future {...}
val myResult : T = Await.result(myFutureResult, secondsToWait seconds)  
```

```scala
    var brokerID = result_opportunityQuery.map{
      data => {
        val dataList = data.toList
        dataList.map(
          item => {
            val _brokerID = item.opportunity_2.currentassignedbroker_C.getOrElse(DEFAULT_BROKER_SF_ID)
            val send_batch_request:SendMessageBatchRequest =
              new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(
                //new SendMessageBatchRequestEntry("brokerID", _brokerID.toString),
                new SendMessageBatchRequestEntry("result_opportunityQuery", item.toString).withDelaySeconds(10)
              )
            sqs.sendMessageBatch(send_batch_request)
            _brokerID
          }
        )
      }
    }

    // brokerID's type is Future[List[String]] 
    val brokerID_ = Await.result(brokerID, 1.seconds)

    /////////Broker
    val brokerQuery = Brokers.filter(br => br.sfid === brokerID_(0) )    // get the value in index 0 of a List       
    ... 

```
