CREATE DATABASE  IF NOT EXISTS `contrader` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `contrader`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: contrader
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `abbonamento`
--

DROP TABLE IF EXISTS `abbonamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `abbonamento` (
  `nome` varchar(45) NOT NULL,
  `prezzo` double DEFAULT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abbonamento`
--

LOCK TABLES `abbonamento` WRITE;
/*!40000 ALTER TABLE `abbonamento` DISABLE KEYS */;
INSERT INTO `abbonamento` VALUES ('business',300),('gold',150),('normale',50),('silver',100);
/*!40000 ALTER TABLE `abbonamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assegnazione`
--

DROP TABLE IF EXISTS `assegnazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assegnazione` (
  `iduser` int(11) NOT NULL,
  `idbadge` int(11) NOT NULL,
  `dataassegnazione` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`iduser`,`idbadge`,`dataassegnazione`),
  KEY `fk_user_has_badge_badge1_idx` (`idbadge`),
  KEY `fk_user_has_badge_user_idx` (`iduser`),
  KEY `flag` (`flag`),
  CONSTRAINT `fk_user_has_badge_badge1` FOREIGN KEY (`idbadge`) REFERENCES `badge` (`idbadge`),
  CONSTRAINT `fk_user_has_badge_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `flag` FOREIGN KEY (`flag`) REFERENCES `stato` (`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assegnazione`
--

LOCK TABLES `assegnazione` WRITE;
/*!40000 ALTER TABLE `assegnazione` DISABLE KEYS */;
INSERT INTO `assegnazione` VALUES (18,1,'18-10-2018','Roberto','Costnatino',1),(18,2,'18-10-2018','Roberto','Costantino',1),(33,3,'18-10-2018','Giuseppe','Arena',1),(33,4,'18-10-2018','Giuseppe','Arena',1);
/*!40000 ALTER TABLE `assegnazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asset` (
  `idasset` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idasset`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (12,'SalaRiunioni',50.5,'6P_F1_S2'),(15,'stampante',10,'F1_S6'),(16,'SalaRiunoini',100.5,'10P_F1_S1'),(17,'SalaRiunioni',150,'15P_F1_S3'),(18,'SalaComputer',80.5,'5P_F1_S4'),(20,'SalaComputer',125.5,'8P_F1_S5');
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `badge`
--

DROP TABLE IF EXISTS `badge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `badge` (
  `idbadge` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`idbadge`),
  KEY `flag_badge_idx` (`flag`),
  CONSTRAINT `flag_badge` FOREIGN KEY (`flag`) REFERENCES `stato` (`flag`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badge`
--

LOCK TABLES `badge` WRITE;
/*!40000 ALTER TABLE `badge` DISABLE KEYS */;
INSERT INTO `badge` VALUES (1,'Protocollo mifareultralightstandard13,56MHz','PVC_ISO7810',1),(2,'Protocollo Em Marin+mifare 1k 125-13,56MHZ','PVC_ISO7810',1),(3,'Protocollo iso 18000-63/gen2 860/960MHz','PVC_ISO7810',1),(4,'Protocollo Mifare S50 iso1443A 13,56MHz','PVC_ISO7810',1),(6,'Protocollo temic+mifare 1k 125-13,56MHz','PVC_ISO7810',1);
/*!40000 ALTER TABLE `badge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `badgereader`
--

DROP TABLE IF EXISTS `badgereader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `badgereader` (
  `idbadgereader` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `idasset` int(11) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`idbadgereader`),
  KEY `fk_badgereader_asset1_idx` (`idasset`),
  KEY `flag` (`flag`),
  CONSTRAINT `flag_br` FOREIGN KEY (`flag`) REFERENCES `stato` (`flag`),
  CONSTRAINT `idasset` FOREIGN KEY (`idasset`) REFERENCES `asset` (`idasset`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badgereader`
--

LOCK TABLES `badgereader` WRITE;
/*!40000 ALTER TABLE `badgereader` DISABLE KEYS */;
INSERT INTO `badgereader` VALUES (3,'SBR badge reader di prossimità','RadioFrequenze',15,1),(5,'HELIOS antideflagrante','E_Ex-d',16,1),(12,'HELIOS antideflagrante','W',12,1);
/*!40000 ALTER TABLE `badgereader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimento`
--

DROP TABLE IF EXISTS `movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movimento` (
  `idbadgereader` int(11) NOT NULL,
  `idbadge` int(11) NOT NULL,
  `datainizio` datetime NOT NULL,
  `datafine` datetime DEFAULT NULL,
  PRIMARY KEY (`idbadgereader`,`idbadge`,`datainizio`),
  KEY `fk_badgereader_has_badge_badge1_idx` (`idbadge`),
  KEY `fk_badgereader_has_badge_badgereader1_idx` (`idbadgereader`),
  CONSTRAINT `fk_badgereader_has_badge_badge1` FOREIGN KEY (`idbadge`) REFERENCES `badge` (`idbadge`),
  CONSTRAINT `fk_badgereader_has_badge_badgereader1` FOREIGN KEY (`idbadgereader`) REFERENCES `badgereader` (`idbadgereader`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimento`
--

LOCK TABLES `movimento` WRITE;
/*!40000 ALTER TABLE `movimento` DISABLE KEYS */;
INSERT INTO `movimento` VALUES (3,1,'2018-10-08 12:00:00','2018-10-08 15:00:00'),(5,3,'2018-10-09 12:00:00','2018-10-09 15:00:00'),(12,4,'2018-10-18 15:00:00','2018-10-18 18:00:00');
/*!40000 ALTER TABLE `movimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prenotazione` (
  `iduser` int(11) NOT NULL,
  `idasset` int(11) NOT NULL,
  `orainizio` varchar(45) NOT NULL,
  `orafine` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`,`idasset`,`orainizio`),
  KEY `fk_prenotazione_asset1_idx` (`idasset`),
  CONSTRAINT `fk_prenotazione_asset1` FOREIGN KEY (`idasset`) REFERENCES `asset` (`idasset`),
  CONSTRAINT `fk_prenotazione_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (18,12,'2018-10-16 01:00:00','2018-10-16 03:00:00');
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stato`
--

DROP TABLE IF EXISTS `stato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stato` (
  `flag` int(11) NOT NULL,
  `valore` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stato`
--

LOCK TABLES `stato` WRITE;
/*!40000 ALTER TABLE `stato` DISABLE KEYS */;
INSERT INTO `stato` VALUES (0,'eliminato'),(1,'attivo');
/*!40000 ALTER TABLE `stato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storico`
--

DROP TABLE IF EXISTS `storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `storico` (
  `idstorico` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `idasset` int(11) DEFAULT NULL,
  `orainizio` datetime DEFAULT NULL,
  `orafine` datetime DEFAULT NULL,
  PRIMARY KEY (`idstorico`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storico`
--

LOCK TABLES `storico` WRITE;
/*!40000 ALTER TABLE `storico` DISABLE KEYS */;
/*!40000 ALTER TABLE `storico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ragioneSociale` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `partitaiva` varchar(45) DEFAULT NULL,
  `ruolo` varchar(45) DEFAULT NULL,
  `nomeAbb` varchar(45) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`iduser`),
  KEY `nomeAbb_idx` (`nomeAbb`),
  KEY `flag` (`flag`) /*!80000 INVISIBLE */,
  CONSTRAINT `flag_user` FOREIGN KEY (`flag`) REFERENCES `stato` (`flag`),
  CONSTRAINT `nomeAbb` FOREIGN KEY (`nomeAbb`) REFERENCES `abbonamento` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (16,'Patrizia','password','','3476545321','Pseg@gmail.com','12435642143','segretaria','normale',1),(18,'roberto','rob123','RobCostruzioniSRL','3333598671','RCostruzioni@hotmail.it','12345676543','cliente','gold',1),(33,'Giuseppe','lamiapassword','GArenaMedicaSPA','3477499868','G.Arena@contrader.it','65432191852','cliente','business',1),(34,'Serrori1','passsord21','SalvoErroriSRLS','3459861329','Salvo.Errori@simail.it','89436182742','cliente','silver',1),(35,'Astrat32','astratsapa','','3332189362','Antonella.Stratti@libero.it','23289136109','segretaria','normale',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userasset`
--

DROP TABLE IF EXISTS `userasset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userasset` (
  `iduser` int(11) NOT NULL,
  `idasset` int(11) NOT NULL,
  `orainizio` datetime NOT NULL,
  `orafine` datetime DEFAULT NULL,
  PRIMARY KEY (`iduser`,`idasset`,`orainizio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userasset`
--

LOCK TABLES `userasset` WRITE;
/*!40000 ALTER TABLE `userasset` DISABLE KEYS */;
/*!40000 ALTER TABLE `userasset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'contrader'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-19  9:48:32
