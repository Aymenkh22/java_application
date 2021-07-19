-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: javadatabase
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `donators`
--

DROP TABLE IF EXISTS `donators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donators` (
  `DONATOR_ID` int NOT NULL AUTO_INCREMENT,
  `DONATOR_FNAME` varchar(45) NOT NULL,
  `DONATOR_LNAME` varchar(45) NOT NULL,
  `DONATOR_NUM` int DEFAULT NULL,
  `DONATOR_ADR` varchar(45) DEFAULT NULL,
  `DONATOR_EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DONATOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donators`
--

LOCK TABLES `donators` WRITE;
/*!40000 ALTER TABLE `donators` DISABLE KEYS */;
INSERT INTO `donators` VALUES (1,'Laura','Dickson',2545972,'2079 Romrog Way','LauraJDickson@rhyta.com '),(2,'Beverly','Ladwig',135342263,'3987 Kinney Street','BeverlyRLadwig@armyspy.com '),(3,'Gregory','Bauer',33358891,'3578 Wexford Way','GregoryMBauer@dayrep.com'),(4,'Eleanor','Steib',798656660,'911 Swick Hill Street','EleanorDSteib@rhyta.com '),(5,'Ashley','Smith',707669958,'443 Cedar Street','AshleyKSmith@teleworm.us '),(6,'Joshua','Rodriguez',82779165,'3127 Stadium Drive','JoshuaSRodriguez@rhyta.com ');
/*!40000 ALTER TABLE `donators` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-24 20:18:36
