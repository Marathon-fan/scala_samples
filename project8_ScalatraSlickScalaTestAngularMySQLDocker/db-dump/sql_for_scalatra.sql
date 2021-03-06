

create database scalatra_test;

use scalatra_test;


CREATE TABLE User(
userId INT NOT NULL AUTO_INCREMENT,  
userName VARCHAR(255),
password VARCHAR(255),
PRIMARY KEY ( userId )
);

CREATE TABLE Post(
postId BIGINT NOT NULL AUTO_INCREMENT, 
text VARCHAR(1024),
createdAt TIMESTAMP,
userId INT, 
PRIMARY KEY ( postId )
);


show tables;

INSERT INTO User (userId, userName, password)
VALUES (DEFAULT, 'Jim', '123');   

INSERT INTO User (userId, userName, password)
VALUES (DEFAULT, 'Tom', '123');

select * from scalatra_test.User;


INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Jim first post', NOW(), 1);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Jim second post', NOW(), 1);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Jim Third post', NOW(), 1);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Tom 1st post', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Tom 2nd post', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Tom 3rd post', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Sample post-a good post', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Sample post-a simple post', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Selling a lovable Australia to the US', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Commonwealth Games gold medallist dies', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'ICC ends Ashes match-fixing probe', NOW(), 2);

INSERT INTO Post (postId, text,  createdAt, userId)
VALUES (DEFAULT, 'Asia markets drop sharply after US falls', NOW(), 2);


select * from scalatra_test.Post;

