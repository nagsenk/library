-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `BookInfo`
--

DROP TABLE IF EXISTS `BookInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BookInfo` (
  `title` char(20) NOT NULL,
  `Author` char(20) DEFAULT NULL,
  `copies` int(11) DEFAULT '1',
  `price` int(11) DEFAULT NULL,
  `Category` char(20) DEFAULT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BookInfo`
--

LOCK TABLES `BookInfo` WRITE;
/*!40000 ALTER TABLE `BookInfo` DISABLE KEYS */;
INSERT INTO `BookInfo` VALUES ('Book1','author1',1,230,'cat1'),('Book2','author2',0,560,'cat8');
/*!40000 ALTER TABLE `BookInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Books`
--

DROP TABLE IF EXISTS `Books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Books` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(20) DEFAULT NULL,
  `availability` char(20) DEFAULT 'available',
  PRIMARY KEY (`bid`),
  KEY `title` (`title`),
  CONSTRAINT `Books_ibfk_1` FOREIGN KEY (`title`) REFERENCES `BookInfo` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Books`
--

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;
INSERT INTO `Books` VALUES (9,'Book1','unavailable'),(10,'Book1','available'),(11,'Book2','unavailable'),(12,'Book1','unavailable'),(13,'Book1','available');
/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` char(20) DEFAULT NULL,
  `lastname` char(20) DEFAULT NULL,
  `usname` char(20) DEFAULT NULL,
  `joindate` date DEFAULT NULL,
  `address` char(40) DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `usname` (`usname`),
  CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`usname`) REFERENCES `authentication` (`username`)
  on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'employee5','employee5','employee5',NULL,NULL),(2,'employee2','employee2l','employee2',NULL,NULL),(3,'employee3','employee3l','employee3',NULL,NULL),(4,'employee13','employee13l','employee13',NULL,NULL),(5,'employee17','employee17l','employee17','2019-10-15','kjhfjf');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Issue`
--

DROP TABLE IF EXISTS `Issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Issue` (
  `Memid` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
  `issuedate` date NOT NULL,
  PRIMARY KEY (`Memid`,`isbn`,`issuedate`),
  KEY `isbn` (`isbn`),
  CONSTRAINT `Issue_ibfk_1` FOREIGN KEY (`Memid`) REFERENCES `members` (`memid`) ON DELETE CASCADE,
  CONSTRAINT `Issue_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `Books` (`bid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Issue`
--

LOCK TABLES `Issue` WRITE;
/*!40000 ALTER TABLE `Issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `Issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reserve`
--

DROP TABLE IF EXISTS `Reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reserve` (
  `MID` int(11) NOT NULL,
  `title` char(30) NOT NULL,
  `reservedate` date NOT NULL,
  PRIMARY KEY (`MID`,`title`,`reservedate`),
  KEY `title` (`title`),
  CONSTRAINT `Reserve_ibfk_1` FOREIGN KEY (`MID`) REFERENCES `members` (`memid`) ON DELETE CASCADE,
  CONSTRAINT `Reserve_ibfk_2` FOREIGN KEY (`title`) REFERENCES `BookInfo` (`title`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reserve`
--

LOCK TABLES `Reserve` WRITE;
/*!40000 ALTER TABLE `Reserve` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Returninfo`
--

DROP TABLE IF EXISTS `Returninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Returninfo` (
  `mID` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
  `returndate` date NOT NULL,
  PRIMARY KEY (`mID`,`isbn`,`returndate`),
  KEY `isbn` (`isbn`),
  CONSTRAINT `Returninfo_ibfk_1` FOREIGN KEY (`mID`) REFERENCES `members` (`memid`) ON DELETE CASCADE,
  CONSTRAINT `Returninfo_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `Books` (`bid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Returninfo`
--

LOCK TABLES `Returninfo` WRITE;
/*!40000 ALTER TABLE `Returninfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Returninfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication`
--

DROP TABLE IF EXISTS `authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authentication` (
  `username` char(20) NOT NULL,
  `role` char(20) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication`
--

LOCK TABLES `authentication` WRITE;
/*!40000 ALTER TABLE `authentication` DISABLE KEYS */;
INSERT INTO `authentication` VALUES ('employee13','employee','employee13',1),('employee17','employee','employee17',1),('employee19','employee','employee19',1),('employee2','employee','employee2',1),('employee3','employee','employee3',1),('employee5','employee','employee5',1),('manager1','manager','manager1',1),('member1','member','member1',1),('member2','member','member2',1),('member7','member','member7',1);
/*!40000 ALTER TABLE `authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `memid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` char(20) DEFAULT NULL,
  `lastname` char(20) DEFAULT NULL,
  `address` char(30) DEFAULT NULL,
  `memusername` char(20) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`memid`),
  KEY `memusername` (`memusername`),
  CONSTRAINT `members_ibfk_1` FOREIGN KEY (`memusername`) REFERENCES `authentication` (`username`),
  CONSTRAINT `members_ibfk_2` FOREIGN KEY (`memusername`) REFERENCES `authentication` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (11,'member1','member1l','pune','member1',7),(12,'member2','member2l','mumbai','member2',3),(14,'member7','member7l','mantri nagar nanded3','member7',0);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meminfo`
--

DROP TABLE IF EXISTS `meminfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meminfo` (
  `memid` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `cellno` int(11) DEFAULT NULL,
  PRIMARY KEY (`memid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meminfo`
--

LOCK TABLES `meminfo` WRITE;
/*!40000 ALTER TABLE `meminfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `meminfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15 14:39:21
