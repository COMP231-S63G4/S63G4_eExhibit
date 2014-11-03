CREATE DATABASE  IF NOT EXISTS `eexhibition` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eexhibition`;

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
