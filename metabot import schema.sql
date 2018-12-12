-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;
-- NOME DEL DATABASE contrader-metabot
-- ************************************** `user_roles`
CREATE SCHEMA IF NOT EXISTS `contrader-metabot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;


CREATE TABLE `contrader-metabot`.`user_types`
(
 `user_type_ID`   int NOT NULL AUTO_INCREMENT ,
 `user_type_name` varchar(45) NOT NULL ,
 `created_at`     datetime NOT NULL ,
 `updated_at`     datetime NOT NULL ,
 `deleted_at`     datetime DEFAULT NULL,
PRIMARY KEY (`user_type_ID`)
);


-- ************************************** `users`

CREATE TABLE `contrader-metabot`.`users`
(
 `user_ID`      int NOT NULL AUTO_INCREMENT ,
 `username`     varchar(45) NOT NULL ,
 `password`     varchar(45) NOT NULL ,
 `email`        varchar(45) NOT NULL ,
 `user_type_FK` int NOT NULL ,
 `created_at`   datetime NOT NULL ,
 `updated_at`   datetime NOT NULL ,
 `deleted_at`   datetime DEFAULT NULL,
PRIMARY KEY (`user_ID`)
);


-- ************************************** `nodes`

CREATE TABLE `contrader-metabot`.`nodes`
(
 `node_ID`    int NOT NULL AUTO_INCREMENT ,
 `chatbot_FK` int NOT NULL ,
 `content`    varchar(256) NOT NULL ,
 `created_at` datetime NOT NULL ,
 `updated_at` datetime NOT NULL ,
 `deleted_at` datetime DEFAULT NULL,
PRIMARY KEY (`node_ID`)
);


-- ************************************** `node_to_node`

CREATE TABLE `contrader-metabot`.`node_to_node`
(
 `first_node_ID`  int NOT NULL ,
 `second_node_ID` int NOT NULL ,
 `created_at`     datetime NOT NULL ,
 `updated_at`     datetime NOT NULL ,
 `deleted_at`     datetime DEFAULT NULL,
PRIMARY KEY (`first_node_ID`, `second_node_ID`)
);


-- ************************************** `chatbots`

CREATE TABLE `contrader-metabot`.`chatbots`
(
 `chatbot_ID`  int NOT NULL AUTO_INCREMENT ,
 `owner_FK`    int NOT NULL ,				-- FOREIIGN KEY A USERS -> USERS solo con USERTYPE = CHAT_MASTER
 `enter_point` int ,						-- FOREIGN KEY NULLABLE;
 `end_point`   int ,						-- FOREIGN KEY NULLABLE;
 `name`        varchar(45) NOT NULL ,		-- MOTIVO : ;
 `welcome`     varchar(256) NOT NULL ,
 `created_at`  datetime NOT NULL ,
 `updated_at`  datetime NOT NULL ,
 `deleted_at`  datetime DEFAULT NULL,
PRIMARY KEY (`chatbot_ID`)
);


-- ************************************** `users`
ALTER TABLE `contrader-metabot`.`users`
ADD CONSTRAINT `user_to_usertype` FOREIGN KEY (`user_type_FK`) REFERENCES `user_types` (`user_type_ID`);


-- ************************************** `nodes`

ALTER TABLE `contrader-metabot`.`nodes`
ADD CONSTRAINT `nodes_to_chatbot` FOREIGN KEY (`chatbot_FK`) REFERENCES `chatbots` (`chatbot_ID`);


-- ************************************** `node_to_node`

ALTER TABLE `contrader-metabot`.`node_to_node`
ADD CONSTRAINT `node_to_node_1` FOREIGN KEY (`first_node_ID`) REFERENCES `nodes` (`node_ID`),
ADD CONSTRAINT `node_to_node_2` FOREIGN KEY (`second_node_ID`) REFERENCES `nodes` (`node_ID`);


-- ************************************** `chatbots`

ALTER TABLE `contrader-metabot`.`chatbots`
ADD CONSTRAINT `chatbot_to_user` FOREIGN KEY (`owner_FK`) REFERENCES `users` (`user_ID`);

