-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: atp
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `coach`
--

DROP TABLE IF EXISTS `coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coach` (
  `CName` varchar(20) NOT NULL,
  `Cdob` date DEFAULT NULL,
  `Ccountry` varchar(20) DEFAULT NULL,
  `coachee` varchar(30) DEFAULT NULL,
  `CoachSince` date DEFAULT NULL,
  `CoachTill` date DEFAULT NULL,
  PRIMARY KEY (`CName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach`
--

LOCK TABLES `coach` WRITE;
/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
INSERT INTO `coach` VALUES ('Boris Becker','1967-11-22','Germany','Novak Djokovic','2013-07-12','2017-04-16');
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `Name` varchar(30) NOT NULL,
  `Country` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `ATPPoints` int(11) DEFAULT NULL,
  `YearPro` int(11) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES ('Andy Murray','United Kingdom','1987-05-15',8370,2005),('David Ferrer','Spain','1982-04-02',3505,2000),('Jo-Wilfred Tsonga','France','1985-04-17',3130,2004),('Juan Martin Del Potro','Argentina','1988-09-23',552,2005),('Kei Nishikori','Japan','1989-12-29',4070,2007),('Marin Cilic','Croatia','1988-09-28',2725,2005),('Milos Raonic','Canada','1990-12-27',2650,2008),('Novak Djokovic','Serbia','1987-05-22',16540,2004),('Rafael Nadal','Spain','1986-06-03',4990,2003),('Richard Gasquet','France','1986-06-18',2795,2002),('Roger Federer','Switzerland','1981-08-08',7695,1998),('Stanlias Wawrinka','Switzerland','1985-03-08',6405,2002),('Thomas Berdych','Czech Republic','1985-09-17',3810,2002);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referee`
--

DROP TABLE IF EXISTS `referee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referee` (
  `RefereeName` varchar(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `Country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`RefereeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referee`
--

LOCK TABLES `referee` WRITE;
/*!40000 ALTER TABLE `referee` DISABLE KEYS */;
INSERT INTO `referee` VALUES ('Ali Nili','1965-11-15','USA'),('Carlos Ramos','1971-03-27','Portugal'),('Jake Garner','1969-03-09','Uganda'),('John Blom','1962-08-18','Australia');
/*!40000 ALTER TABLE `referee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sponsor` (
  `SponsorName` varchar(20) NOT NULL,
  `PlayerSponsored` varchar(30) DEFAULT NULL,
  `ContractYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`SponsorName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournament`
--

DROP TABLE IF EXISTS `tournament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tournament` (
  `TournamentName` varchar(30) NOT NULL,
  `CourtType` varchar(20) DEFAULT NULL,
  `ATPCategory` int(11) DEFAULT NULL,
  `YearBegin` int(11) DEFAULT NULL,
  PRIMARY KEY (`TournamentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament`
--

LOCK TABLES `tournament` WRITE;
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
INSERT INTO `tournament` VALUES ('Australian Open','Hard',2000,1990),('Basel Open','Hard',500,1999),('Canada Masters','Hard',1000,1995),('Cincinnati Open','Hard',1000,1994),('Dubai Open','Hard',500,1998),('French Open','Clay',2000,1991),('Halle Open','Grass',500,1996),('Hamburg Open','Clay',500,1997),('Indian Wells','Hard',1000,1995),('Madrid Open','Clay',1000,1994),('Monte Carlo','Clay',1000,1996),('Queens','Grass',500,1998),('Shanghai Masters','Hard',1000,1997),('US Open','Hard',2000,1992),('Wimbledon','Grass',2000,1990),('World Tour Finals','Hard',1000,1996);
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-16  2:30:30
