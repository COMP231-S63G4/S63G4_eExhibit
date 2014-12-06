CREATE DATABASE  IF NOT EXISTS `eexhibition` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eexhibition`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: eexhibition
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `biddingdetails`
--

DROP TABLE IF EXISTS `biddingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biddingdetails` (
  `productid` varchar(30) DEFAULT NULL,
  `uname` varchar(30) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biddingdetails`
--

LOCK TABLES `biddingdetails` WRITE;
/*!40000 ALTER TABLE `biddingdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `biddingdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biddingproduct`
--

DROP TABLE IF EXISTS `biddingproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biddingproduct` (
  `eventid` varchar(30) DEFAULT NULL,
  `productid` varchar(30) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `startprice` varchar(10) DEFAULT NULL,
  `closeprice` varchar(10) DEFAULT NULL,
  `uname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biddingproduct`
--

LOCK TABLES `biddingproduct` WRITE;
/*!40000 ALTER TABLE `biddingproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `biddingproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currentproducts`
--

DROP TABLE IF EXISTS `currentproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currentproducts` (
  `eventid` varchar(30) DEFAULT NULL,
  `productid` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentproducts`
--

LOCK TABLES `currentproducts` WRITE;
/*!40000 ALTER TABLE `currentproducts` DISABLE KEYS */;
INSERT INTO `currentproducts` VALUES ('E4.220106829767872E7','1'),('E4.220106829767872E7','2'),('E4.220106829767872E7','3');
/*!40000 ALTER TABLE `currentproducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventexhibitor`
--

DROP TABLE IF EXISTS `eventexhibitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventexhibitor` (
  `eventid` varchar(30) DEFAULT NULL,
  `exhibitoruname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventexhibitor`
--

LOCK TABLES `eventexhibitor` WRITE;
/*!40000 ALTER TABLE `eventexhibitor` DISABLE KEYS */;
INSERT INTO `eventexhibitor` VALUES ('E4.220106829767872E7','jagraj');
/*!40000 ALTER TABLE `eventexhibitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `eventid` varchar(30) NOT NULL,
  `eventname` varchar(100) DEFAULT NULL,
  `details` varchar(1000) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `eventorganisers` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES ('E4.220106829767872E7','Painting Art','paintings will be displayed','toronto','0015-05-12','0015-06-13','Jagraj Sidhu'),('E7.155175555400835E7','Tech Art','technology gadgets','scarborugh','2014-12-12','2014-12-14','komal');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `uname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `type` varchar(4) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','sidhu','admn'),('jaadu','jaadu','exbt'),('jagraj','jagraj','exbt'),('jasmeet','jasmeet','exbt'),('lol','lol','rusr'),('raman','raman','orgn'),('rupam','rupam','orgn');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `uname` varchar(30) NOT NULL,
  `notification` varchar(800) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pendingrequest`
--

DROP TABLE IF EXISTS `pendingrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendingrequest` (
  `uname` varchar(30) DEFAULT NULL,
  `eventid` varchar(30) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendingrequest`
--

LOCK TABLES `pendingrequest` WRITE;
/*!40000 ALTER TABLE `pendingrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `pendingrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `productid` varchar(30) NOT NULL,
  `producttitle` varchar(85) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `image` varchar(60) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `exhibitoruname` varchar(30) DEFAULT NULL,
  `kind` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('1','A','A','A','10','bidd','jagraj','special'),('2','B','B','B','11','bidd','jagraj','special'),('3','C','C','c','13','bidd','jaadu','special');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportedcontent`
--

DROP TABLE IF EXISTS `reportedcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportedcontent` (
  `productid` varchar(30) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `userid` varchar(30) NOT NULL,
  PRIMARY KEY (`productid`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportedcontent`
--

LOCK TABLES `reportedcontent` WRITE;
/*!40000 ALTER TABLE `reportedcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportedcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soldproducts`
--

DROP TABLE IF EXISTS `soldproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soldproducts` (
  `productid` varchar(30) NOT NULL DEFAULT '',
  `eventid` varchar(30) DEFAULT NULL,
  `buyeruname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soldproducts`
--

LOCK TABLES `soldproducts` WRITE;
/*!40000 ALTER TABLE `soldproducts` DISABLE KEYS */;
/*!40000 ALTER TABLE `soldproducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `uname` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('jaadu','jaadu','abc@abc.com','123232','56 rererst'),('jagraj','Jagraj Singh','jagraj.brar@gmail.com','4166255096','centennial college'),('jasmeet','jasmeet','jasmeet@gmail.com','415656895','centennial college'),('lol','lol','lol@lol.com','123232','lol'),('raman','raman','lkmcd','lkfd','ABC street'),('rupam','Rup Grewal','jdhdh@hsuj.con','4204230420','123 Chor gali');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-06 14:58:55
