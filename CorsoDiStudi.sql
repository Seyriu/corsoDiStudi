CREATE DATABASE  IF NOT EXISTS `corsodistudi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `corsodistudi`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: corsodistudi
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calendario_classe`
--

DROP TABLE IF EXISTS `calendario_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario_classe` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_SEMESTRE` bigint(20) NOT NULL,
  `ID_GIORNO` bigint(20) NOT NULL,
  `ID_ORA` bigint(20) NOT NULL,
  `ID_CLASSE` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario_classe`
--

LOCK TABLES `calendario_classe` WRITE;
/*!40000 ALTER TABLE `calendario_classe` DISABLE KEYS */;
INSERT INTO `calendario_classe` VALUES (1,1,2,2,1),(2,2,1,3,2),(3,1,2,2,2),(4,1,2,2,3);
/*!40000 ALTER TABLE `calendario_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario_x_materia`
--

DROP TABLE IF EXISTS `calendario_x_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario_x_materia` (
  `ID_CALENDARIO` bigint(20) NOT NULL,
  `ID_MATERIA` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario_x_materia`
--

LOCK TABLES `calendario_x_materia` WRITE;
/*!40000 ALTER TABLE `calendario_x_materia` DISABLE KEYS */;
INSERT INTO `calendario_x_materia` VALUES (1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `calendario_x_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,'A'),(2,'B'),(3,'C');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giorno_settimanale`
--

DROP TABLE IF EXISTS `giorno_settimanale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giorno_settimanale` (
  `ID_G_S` bigint(20) NOT NULL AUTO_INCREMENT,
  `GIORNO_SETTIMANALE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_G_S`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giorno_settimanale`
--

LOCK TABLES `giorno_settimanale` WRITE;
/*!40000 ALTER TABLE `giorno_settimanale` DISABLE KEYS */;
INSERT INTO `giorno_settimanale` VALUES (1,'LUN'),(2,'MAR'),(3,'MER'),(4,'GIO'),(5,'VEN');
/*!40000 ALTER TABLE `giorno_settimanale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'ANALISI'),(2,'GEOMETRIA'),(3,'ALGEBRA');
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_x_ora`
--

DROP TABLE IF EXISTS `materia_x_ora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_x_ora` (
  `ID_MATERIA` bigint(20) NOT NULL,
  `ID_ORA` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_x_ora`
--

LOCK TABLES `materia_x_ora` WRITE;
/*!40000 ALTER TABLE `materia_x_ora` DISABLE KEYS */;
INSERT INTO `materia_x_ora` VALUES (1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `materia_x_ora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_x_prof`
--

DROP TABLE IF EXISTS `materia_x_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_x_prof` (
  `ID_MATERIA` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_x_prof`
--

LOCK TABLES `materia_x_prof` WRITE;
/*!40000 ALTER TABLE `materia_x_prof` DISABLE KEYS */;
INSERT INTO `materia_x_prof` VALUES (1),(1),(1),(2),(3);
/*!40000 ALTER TABLE `materia_x_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ora`
--

DROP TABLE IF EXISTS `ora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ora` (
  `ID_ORA` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORA` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_ORA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ora`
--

LOCK TABLES `ora` WRITE;
/*!40000 ALTER TABLE `ora` DISABLE KEYS */;
INSERT INTO `ora` VALUES (1,'9-10'),(2,'10-11'),(3,'11-12');
/*!40000 ALTER TABLE `ora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professore`
--

DROP TABLE IF EXISTS `professore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professore` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `COGNOME` varchar(45) NOT NULL,
  `MAIL` varchar(250) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professore`
--

LOCK TABLES `professore` WRITE;
/*!40000 ALTER TABLE `professore` DISABLE KEYS */;
INSERT INTO `professore` VALUES (1,'Franco','Bisio','franco@gmail.com'),(2,'Federico','rossi','fede@gmail.com'),(3,'Lorenzo','Rio','rio@gmail.com');
/*!40000 ALTER TABLE `professore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestre`
--

DROP TABLE IF EXISTS `semestre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semestre` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SEMESTRE` int(11) DEFAULT NULL,
  `ANNO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestre`
--

LOCK TABLES `semestre` WRITE;
/*!40000 ALTER TABLE `semestre` DISABLE KEYS */;
INSERT INTO `semestre` VALUES (1,1,2018),(2,2,2018);
/*!40000 ALTER TABLE `semestre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studente` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `COGNOME` varchar(45) NOT NULL,
  `DATA_DI_NASCITA` date NOT NULL,
  `MAIL` varchar(250) NOT NULL,
  `CODICE_FISCALE` varchar(16) NOT NULL,
  `MATRICOLA` varchar(7) NOT NULL,
  `ID_TASSA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES (1,'Mario ','Rossi','1999-12-23','mario.rossi@gmail.com','RSSMRI97H03G458S','53343',1),(2,'Carlo','Verdi','1998-04-12','carlo.verdi@gmail.com','VRDCRL98E12A432J','54523',2),(3,'Federica','Russo','1995-05-14','federica.russo@mail.com','RSSFDR95H14D786J','43243',2),(4,'Roberta','Bianchi','1997-11-11','roberta@gmail.com','BNCRBE97H11G345H','54342',1);
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tassa`
--

DROP TABLE IF EXISTS `tassa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tassa` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ISEE` varchar(100) DEFAULT NULL,
  `COSTO` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tassa`
--

LOCK TABLES `tassa` WRITE;
/*!40000 ALTER TABLE `tassa` DISABLE KEYS */;
INSERT INTO `tassa` VALUES (1,'<=10000',300.00),(2,'>10000',450.00);
/*!40000 ALTER TABLE `tassa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voto`
--

DROP TABLE IF EXISTS `voto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voto` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VALUTAZIONE` int(11) DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `ID_SEMESTRE` bigint(20) DEFAULT NULL,
  `ID_MATERIA` bigint(20) DEFAULT NULL,
  `ID_STUDENTE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voto`
--

LOCK TABLES `voto` WRITE;
/*!40000 ALTER TABLE `voto` DISABLE KEYS */;
INSERT INTO `voto` VALUES (1,18,'2018-01-12',1,1,1),(2,20,'2018-01-23',1,2,1),(3,28,'2018-01-28',1,2,2),(4,26,'2018-01-23',1,3,2);
/*!40000 ALTER TABLE `voto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voto_x_prof`
--

DROP TABLE IF EXISTS `voto_x_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voto_x_prof` (
  `ID_PROF` bigint(20) NOT NULL,
  `ID_VOTI` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voto_x_prof`
--

LOCK TABLES `voto_x_prof` WRITE;
/*!40000 ALTER TABLE `voto_x_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `voto_x_prof` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-17 16:56:32
