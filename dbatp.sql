-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: atp
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `TournamentType` varchar(30) NOT NULL,
  `Winner` int(11) DEFAULT NULL,
  `Finalist` int(11) DEFAULT NULL,
  `Semifinalist` int(11) DEFAULT NULL,
  `Quarters` int(11) DEFAULT NULL,
  `Prequarters` int(11) DEFAULT NULL,
  PRIMARY KEY (`TournamentType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('ATP 1000',1000,600,360,180,90),('ATP 250',250,150,90,45,20),('ATP 500',500,300,180,90,45),('Grand Slam',2000,1200,720,360,180);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`CName`),
  KEY `coachee` (`coachee`),
  CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`coachee`) REFERENCES `player` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach`
--

LOCK TABLES `coach` WRITE;
/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
INSERT INTO `coach` VALUES ('Amelie Mauresmo','1979-07-05','France','Andy Murray','2014-06-08','2016-04-16'),('Bob Brett','1953-03-17','Australia','Marin Cilic','2004-01-01','2013-12-31'),('Boris Becker','1967-11-22','Germany','Novak Djokovic','2013-07-12','2017-04-16'),('Carlos Moya','1976-08-27','Spain','Milos Raonic','2016-01-01','2016-04-16'),('Daniel Vallverdu','1986-03-17','Venezuela','Thomas Berdych','2014-11-24','2016-04-16'),('Franco Davin','1970-01-11','Argentina','Juan Martin Del Potro','2008-11-18','2015-03-31'),('Ivan Lendl','1960-03-07','USA','Andy Murray','2011-12-31','2014-03-19'),('Ivan Ljubicic','1979-03-19','Croatia','Milos Raonic','2013-06-04','2015-12-31'),('Javier Piles','1969-10-22','Spain','David Ferrer','2000-05-08','2013-12-31'),('Michael Chang','1972-02-22','USA','Kei Nishikori','2014-01-05','2016-04-16'),('Paul Annacone','1963-03-20','USA','Roger Federer','2010-08-28','2013-02-05'),('Peter Lundgren','1985-03-28','Switzerland','Stanislas Wawrinka','2010-05-18','2012-09-11'),('Roger Rasheed','1969-03-10','Australia','Jo-Wilfred Tsonga','2012-10-01','2013-10-09'),('Sebastien Grosjean','1978-05-29','France','Richard Gasquet','2014-05-17','2016-04-16'),('Sergi Bruguera','1971-01-16','Spain','Richard Gasquet','2013-01-01','2016-04-16'),('Severin Lüthi','1976-01-05','Switzerland','Roger Federer','2007-03-23','2016-04-16'),('Stefan Edberg','1966-01-19','Sweden','Roger Federer','2013-10-02','2015-11-15'),('Thierry Ascione','1981-01-17','France','Jo-Wilfred Tsonga','2013-09-19','2016-04-16'),('Todd Martin','1970-07-08','USA','Novak Djokovic','2009-08-08','2010-04-12'),('Toni Nadal','1961-02-27','Spain','Rafael Nadal','2002-04-04','2016-04-16');
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `Tourname` varchar(20) NOT NULL,
  `tyear` int(11) NOT NULL,
  `tPlayerWon` varchar(30) NOT NULL,
  `tPlayerLost` varchar(30) DEFAULT NULL,
  `tRound` varchar(20) NOT NULL,
  `Tref` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Tourname`,`tyear`,`tRound`,`tPlayerWon`),
  KEY `tPlayerWon` (`tPlayerWon`),
  KEY `tPlayerLost` (`tPlayerLost`),
  KEY `Tref` (`Tref`),
  CONSTRAINT `matches_ibfk_1` FOREIGN KEY (`tPlayerWon`) REFERENCES `player` (`Name`),
  CONSTRAINT `matches_ibfk_2` FOREIGN KEY (`tPlayerLost`) REFERENCES `player` (`Name`),
  CONSTRAINT `matches_ibfk_3` FOREIGN KEY (`Tref`) REFERENCES `referee` (`RefereeName`),
  CONSTRAINT `matches_ibfk_4` FOREIGN KEY (`Tourname`) REFERENCES `tournament` (`TournamentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES ('Australian Open',2005,'Marat Safin','Lleyton Hewitt','Finals','Bruno Rebeuh'),('Australian Open',2005,'Lleyton Hewitt','Andy Roddick','Semifinals','Fabian Cherny'),('Australian Open',2011,'Roger Federer','Andy Murray','Finals','Carlos Ramos'),('Australian Open',2011,'Andy Murray','Marin Cilic','Semifinals','John Blom'),('Australian Open',2012,'Novak Djokovic','Rafael Nadal','Finals','John Blom'),('Australian Open',2012,'Kei Nishikori','Jo-Wilfred Tsonga','Pre-Quaterfinals','Carlos Ramos'),('Australian Open',2012,'Novak Djokovic','Andy Murray','Semifinals','Fabian Cherny'),('Canada Masters',2011,'Novak Djokovic','Rafael Nadal','Finals','Steve Ullrich'),('Canada Masters',2011,'Rafael Nadal','Juan Martin Del Potro','Semifinals','Ali Nili'),('Cincinnati Masters',2005,'Roger Federer','Andy Roddick','Finals','Jane Harvey'),('Cincinnati Masters',2005,'Andy Murray','Lleyton Hewitt','Semifinals','Fabian Cherny'),('Cincinnati Masters',2009,'Roger Federer','Novak Djokovic','Finals','Carlos Bernardes'),('Cincinnati Masters',2009,'Roger Federer','Andy Murray','Semifinals','Felix Torralba'),('Cincinnati Masters',2011,'Andy Murray','Novak Djokovic','Finals','Fabian Cherny'),('Cincinnati Masters',2011,'Novak Djokovic','Thomas Berdych','Semifinals','Jake Garner'),('Dubai Open',2013,'Thomas Berdych','Roger Federer','Semifinals','John Blom'),('French Open',2005,'Rafael Nadal','Mikhail Youzhny','Finals','Carlos Bernardes'),('French Open',2005,'Rafael Nadal','Roger Federer','Semifinals','Steve Ullrich'),('French Open',2011,'Rafael Nadal','Roger Federer','Finals','Jane Harvey'),('French Open',2011,'Rafael Nadal','Andy Murray','Semifinals','Felix Torralba'),('French Open',2012,'Rafael Nadal','Novak Djokovic','Finals','Steve Ullrich'),('French Open',2012,'Roger Federer','Juan Martin Del Potro','Quaterfinals','Jane Harvey'),('French Open',2012,'Novak Djokovic','Roger Federer','Semifinals','Sylvia Watts'),('German Open Hamburg',2011,'Grigor Dimitrov','Nicolas Almagro','Finals','Jake Garner'),('Indian Wells Masters',2011,'Novak Djokovic','Rafael Nadal','Finals','Sylvia Watts'),('Indian Wells Masters',2011,'Rafael Nadal','Juan Martin Del Potro','Semifinals','Carlos Bernardes'),('Madrid Open',2011,'Novak Djokovic','Rafael Nadal','Finals','Bruno Rebeuh'),('Madrid Open',2011,'Richard Gasquet','Novak Djokovic','Semifinals','Felix Torralba'),('Monte Carlo Masters',2005,'Rafael Nadal','Andy Roddick','Finals','Carlos Ramos'),('Monte Carlo Masters',2005,'Rafael Nadal','Richard Gasquet','Semifinals','Sylvia Watts'),('Monte Carlo Masters',2011,'Rafael Nadal','David Ferrer','Finals','Jane Harvey'),('Monte Carlo Masters',2011,'David Ferrer','Nicolas Almagro','Semifinals','John Blom'),('Shanghai Masters',2011,'Andy Murray','David Ferrer','Finals','Steve Ullrich'),('Shanghai Masters',2011,'Andy Murray','Kei Nishikori','Semifinals','Carlos Ramos'),('Swiss Indoors',2013,'Roger Federer','Juan Martin Del Potro','Finals','Felix Torralba'),('Swiss Indoors',2013,'Juan Martin Del Potro','Kei Nishikori','Semifinals','Carlos Ramos'),('US Open',2005,'Roger Federer','Feliciano Lopez','Finals','John Blom'),('US Open',2005,'Roger Federer','Ivo Karlovic','Semifinals','Fabian Cherny'),('US Open',2011,'Novak Djokovic','Rafael Nadal','Finals','Fabian Cherny'),('US Open',2011,'Novak Djokovic','Roger Federer','Semifinals','Felix Torralba'),('US Open',2012,'Andy Murray','Novak Djokovic','Finals','John Blom'),('US Open',2012,'Novak Djokovic','Stanislas Wawrinka','Pre-Quaterfinals','Fabian Cherny'),('US Open',2012,'Thomas Berdych','Roger Federer','Quaterfinals','Carlos Bernardes'),('US Open',2012,'Andy Murray','Thomas Berdych','Semifinals','Ali Nili'),('Wimbledon',2005,'Roger Federer','Andy Roddick','Finals','Carlos Bernardes'),('Wimbledon',2005,'Roger Federer','Lleyton Hewitt','Semifinals','Ali Nili'),('Wimbledon',2011,'Novak Djokovic','Rafael Nadal','Finals','Sylvia Watts'),('Wimbledon',2011,'Novak Djokovic','Jo-Wilfred Tsonga','Semifinals','Bruno Rebeuh'),('Wimbledon',2012,'Roger Federer','Andy Murray','Finals','Felix Torralba'),('Wimbledon',2012,'Andy Murray','David Ferrer','Quaterfinals','John Blom'),('Wimbledon',2012,'Roger Federer','Novak Djokovic','Semifinals','Jake Garner'),('World Tour Finals',2005,'Marat Safin','Roger Federer','Finals','Ali Nili'),('World Tour Finals',2011,'Roger Federer','Jo-Wilfred Tsonga','Finals','Fabian Cherny'),('World Tour Finals',2011,'Jo-Wilfred Tsonga','Thomas Berdych','Semifinals','Felix Torralba');
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
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
INSERT INTO `player` VALUES ('Andy Murray','United Kingdom','1987-05-15',8370,2005),('Andy Roddick','USA','1982-08-20',0,2000),('Bernard Tomic','Australia','1992-10-21',1625,2008),('David Ferrer','Spain','1982-04-02',3505,2000),('Feliciano Lopez','Spain','1981-09-20',1585,1997),('Gael Monfils','France','1986-09-01',2220,2004),('Grigor Dimitrov','Bulgaria','1991-05-16',1430,2008),('Ivo Karlovic','Croatia','1979-10-23',1270,1997),('Jo-Wilfred Tsonga','France','1985-04-17',3130,2004),('John Isner','USA','1985-04-26',2235,2007),('Juan Martin Del Potro','Argentina','1988-09-23',552,2005),('Kei Nishikori','Japan','1989-12-29',4070,2007),('Lleyton Hewitt','Australia','1981-02-24',0,1998),('Marat Safin','Russian Federation','1980-01-27',0,1997),('Marin Cilic','Croatia','1988-09-28',2725,2005),('Mikhail Youzhny','Russian Federation','1982-06-25',695,1999),('Milos Raonic','Canada','1990-12-27',2650,2008),('Nicolas Almagro','Spain','1985-08-21',749,2003),('Novak Djokovic','Serbia','1987-05-22',16540,2004),('Philip Kohlschreiber','Germany','1983-10-16',1330,2001),('Rafael Nadal','Spain','1986-06-03',4990,2003),('Richard Gasquet','France','1986-06-18',2795,2002),('Roger Federer','Switzerland','1981-08-08',7695,1998),('Stanislas Wawrinka','Switzerland','1985-03-08',6405,2002),('Thomas Berdych','Czech Republic','1985-09-17',3810,2002);
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
INSERT INTO `referee` VALUES ('Ali Nili','1965-11-15','USA'),('Bruno Rebeuh','1964-03-05','France'),('Carlos Bernardes','1971-11-16','Brazil'),('Carlos Ramos','1971-03-27','Portugal'),('Fabian Cherny','1952-05-14','Argentina'),('Felix Torralba','1968-10-18','Spain'),('Jake Garner','1969-03-09','Uganda'),('Jane Harvey','1970-09-25','United Kingdom'),('John Blom','1962-08-18','Australia'),('Steve Ullrich','1959-08-03','USA'),('Sylvia Watts','1966-06-19','United Kingdom');
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
  PRIMARY KEY (`SponsorName`),
  KEY `PlayerSponsored` (`PlayerSponsored`),
  CONSTRAINT `sponsor_ibfk_1` FOREIGN KEY (`PlayerSponsored`) REFERENCES `player` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
INSERT INTO `sponsor` VALUES ('Adidas','Andy Murray',2009),('Aviva','Milos Raonic',2015),('Babolat','Jo-Wilfred Tsonga',2009),('D.Hedral','Stanislas Wawrinka',2015),('Gilette','Roger Federer',2007),('H&M','Thomas Berdych',2013),('Head Graphene','Richard Gasquet',2004),('Kia Motors','Rafael Nadal',2006),('Lacoste','Milos Raonic',2011),('Li-Ning','Marin Cilic',2011),('Lotto Sports Italia','David Ferrer',2008),('Luxilon ALU','Juan Martin Del Potro',2008),('Mercedez-Benz','Roger Federer',2010),('Morinaga & Company','Kei Nishikori',2011),('Nike','Roger Federer',2008),('Quely','Rafael Nadal',2010),('Rado','Andy Murray',2012),('Rolex','Roger Federer',2006),('Sergio Tacchini','Novak Djokovic',2009),('Uniqlo','Novak Djokovic',2012),('Wilson','Roger Federer',2006),('Yonex','Stanislas Wawrinka',2012);
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
  `ATPCategory` varchar(20) DEFAULT NULL,
  `YearBegin` int(11) DEFAULT NULL,
  PRIMARY KEY (`TournamentName`),
  KEY `ATPCategory` (`ATPCategory`),
  CONSTRAINT `tournament_ibfk_1` FOREIGN KEY (`ATPCategory`) REFERENCES `category` (`TournamentType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament`
--

LOCK TABLES `tournament` WRITE;
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
INSERT INTO `tournament` VALUES ('Australian Open','Hard','Grand Slam',1905),('Canada Masters','Hard','ATP 1000',1881),('Cincinnati Masters','Hard','ATP 1000',1899),('Dubai Open','Hard','ATP 500',1993),('French Open','Clay','Grand Slam',1891),('German Open Hamburg','Clay','ATP 500',1892),('Halle Open','Grass','ATP 500',1993),('Indian Wells Masters','Hard','ATP 1000',1974),('Madrid Open','Clay','ATP 1000',2002),('Monte Carlo Masters','Clay','ATP 1000',1897),('Queen\'s Club Championships','Grass','ATP 500',1890),('Shanghai Masters','Hard','ATP 1000',2009),('Swiss Indoors','Hard','ATP 500',1970),('US Open','Hard','Grand Slam',1881),('Wimbledon','Grass','Grand Slam',1877),('World Tour Finals','Hard','ATP 1000',1970);
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

-- Dump completed on 2016-04-28  4:30:57
