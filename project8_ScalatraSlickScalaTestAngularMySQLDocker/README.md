# project8_ScalatraSlickScalaTestAngularMySQLDocker #

## Build & Run ##
### step1 install mysql  
use sql_for_scalatra.txt to install mysql, create db, table, and insert initial data  

### step2 scalatraBackend  
enter scalatraBackend folder and use sbt run backend   
```
$ cd 
$ chmod +x sbt
$ ./sbt ~test 
$ ./sbt ~jetty:start
```

### step3 client  
enter client folder and use npm to run the front end  
```
$ npm install  
$ npm start
```

### step4 navigate  
use your browser to navigate to localhost:4200 to see the result  
you can add a post  
you can delete a post    
the user management is the backend functionality and is not exposed yet(but you can use postman to test it)  

