-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: contrader-schema
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `nodes`
--

DROP TABLE IF EXISTS `nodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nodes` (
  `nodes_id` int(11) NOT NULL,
  `chatbots_id_fk` int(11) NOT NULL,
  `users_id_fk` int(11) NOT NULL,
  `bot_messages_id_fk` int(11) NOT NULL,
  `sequence` int(11) NOT NULL COMMENT 'Sequenza per rendere intercambiabile l''ordine delle domande',
  PRIMARY KEY (`nodes_id`),
  KEY `users_id_fk_idx` (`users_id_fk`),
  KEY `chatbots_id_fk_idx` (`chatbots_id_fk`),
  KEY `bot_messages_id_fk_idx` (`bot_messages_id_fk`),
  CONSTRAINT `bot_messages_id_fk` FOREIGN KEY (`bot_messages_id_fk`) REFERENCES `bot_messages` (`bot_message_id`),
  CONSTRAINT `chatbots_id_fk` FOREIGN KEY (`chatbots_id_fk`) REFERENCES `chatbots` (`chatbot_id`),
  CONSTRAINT `users_id_fk` FOREIGN KEY (`users_id_fk`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodes`
--

LOCK TABLES `nodes` WRITE;
/*!40000 ALTER TABLE `nodes` DISABLE KEYS */;
INSERT INTO `nodes` (`nodes_id`, `chatbots_id_fk`, `users_id_fk`, `bot_messages_id_fk`, `sequence`) VALUES (1,1,3,1,1),(2,1,3,2,2),(3,1,3,3,3),(4,2,5,1,1),(5,2,5,2,2);
/*!40000 ALTER TABLE `nodes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-06 17:42:20
