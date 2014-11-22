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
-- Table structure for table `Bidding Product`
--

CREATE TABLE `Bidding Products` (
  `Eventid` varchar(30) NOT NULL,
  `Productid` varchar(30) NOT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `StartPrice` varchar(30) NOTNULL,
  `EndPrice` varchar(30) NOTNULL,
  `Uname` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `Bidding Details` (
  
  `Productid` varchar(30) NOT NULL,
  `Uname` varchar(400) DEFAULT NULL,
  `Price` varchar(30) NOTNULL,
   PRIMARY KEY (`Productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



