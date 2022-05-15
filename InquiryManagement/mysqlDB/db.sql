-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: inquiry_management
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cus`
--

DROP TABLE IF EXISTS `cus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cus` (
  `code` int NOT NULL AUTO_INCREMENT,
  `cusID` varchar(10) DEFAULT NULL,
  `cusName` varchar(45) DEFAULT NULL,
  `eleAccNo` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `massage` varchar(255) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`,`eleAccNo`),
  UNIQUE KEY `eleAccNo_UNIQUE` (`eleAccNo`),
  UNIQUE KEY `cusID_UNIQUE` (`cusID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cus`
--

LOCK TABLES `cus` WRITE;
/*!40000 ALTER TABLE `cus` DISABLE KEYS */;
INSERT INTO `cus` VALUES (1,'C001','Perera','12345678','114/A,Delgoda','perera@gmail.com','789876654','help','I need Help','complete','1234'),(2,'C002','Divya','87654321','113, colombo','divya@gmail.com','705854137','complain','I had complain','pending','1342'),(3,'C003','Dilshi','81235467','Malabe','dilshi@gmail.com','789874432','help','I need help','complete','3455'),(4,'C004','Tishani','87678765','delgoda','tishani@email.com','786543345','help','need help','complete','5674'),(5,'C005','Ureshi','98786543','colombo','ureshi@gmail.com','786543342','complain','need help','complete','7689'),(6,'C006','Dasuni','12343212','colombo','dasuni@gmail.com','786543342','complain','need help','complete','6547');
/*!40000 ALTER TABLE `cus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 21:11:24
