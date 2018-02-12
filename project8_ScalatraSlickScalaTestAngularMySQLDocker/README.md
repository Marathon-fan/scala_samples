# project8_ScalatraSlickScalaTestAngularMySQLDocker #

## Build & Run ##
### step1 install mysql  
use sql_for_scalatra.txt to install mysql, create db, table, and insert initial data  

### step2 scalatraBackend  
enter scalatraBackend folder and use sbt run backend   
```
$ cd scalatraBackend  
$ chmod +x sbt
$ ./sbt ~test 
$ ./sbt ~jetty:start
```

### step3 client  
enter client folder and use npm to run the front end  
```
$ cd client  
$ npm install  
$ npm start
```

### step4 navigate  
use your browser to navigate to localhost:4200 to see the result  
you can add a post  
you can delete a post    
the user management is the backend functionality and is not exposed yet(but you can use postman to test it)  

## restful design  
1) add a  user  
post localhost:8080/db/api/user/?username=xxx&&password=xxx    
2) delete a user    
delete localhost:8080/db/api/user/?userId=xx  
3) get all users  
get localhost:8080/db/api/users  
4) add a post   
post localhost:8080/db/api/post/?text=xxx&&userId=xxxxx  
5) delete a post  
post localhost:8080/db/api/post_delete/?postId=xx  // use post to simulate post method(to delete a post)  as some browsers don't support DELETE method  
6) get all posts  
get localhost:8080/db/api/posts  