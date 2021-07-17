-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: consultoriodb
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consulta_medica`
--

DROP TABLE IF EXISTS `consulta_medica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta_medica` (
  `id_consultam` bigint NOT NULL AUTO_INCREMENT,
  `fecha_consulta` datetime DEFAULT NULL,
  `medicamentos` varchar(255) DEFAULT NULL,
  `id_doctor` bigint DEFAULT NULL,
  `id_paciente` bigint DEFAULT NULL,
  PRIMARY KEY (`id_consultam`),
  KEY `idDoctor` (`id_doctor`),
  KEY `idPaciente` (`id_paciente`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta_medica`
--

LOCK TABLES `consulta_medica` WRITE;
/*!40000 ALTER TABLE `consulta_medica` DISABLE KEYS */;
INSERT INTO `consulta_medica` VALUES (8,'2021-07-11 16:19:25','asitromicina',9,3),(10,'2021-07-12 16:17:17','asitromicina, Naproxol',12,7),(11,'2021-07-12 16:18:31','SunSolar 50',4,2),(12,'2021-07-12 16:20:35','Azitromicna',10,3),(13,'2021-07-12 16:21:32','SunLate 70',4,8),(14,'2021-07-12 16:22:32','Azitromicina 500gr',13,2),(15,'2021-07-12 16:23:26','Jarabe tos al cos',14,10),(16,'2021-07-12 16:24:13','novadol',15,9),(17,'2021-07-12 16:24:51','calmadolcito',14,11),(18,'2021-07-12 16:25:07','calmadolcito',14,13),(19,'2021-07-12 16:25:20','calmadolcito',14,15),(20,'2021-07-12 16:26:01','Novadol',15,17),(21,'2021-07-12 16:26:31','Azitromicina',16,17),(22,'2021-07-12 16:26:51','Azitromicina',21,17),(23,'2021-07-12 16:27:59','Novadol, calmadolcito',20,18),(24,'2021-07-12 16:28:22','Novadol, calmadolcito',19,16),(25,'2021-07-12 16:28:56','Novadol, calmadolcito',18,15),(26,'2021-07-13 00:27:57','novadol',12,2),(27,'2021-07-13 00:40:14','SunLate 70',4,11),(30,'2021-07-13 00:49:44','flavicol',13,7),(29,'2021-07-13 00:47:29','jarabe tos al cos',14,8),(32,'2021-07-15 01:09:43','flavicol',20,15),(33,'2021-07-15 02:32:30','flavicol',18,15);
/*!40000 ALTER TABLE `consulta_medica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id_doctor` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `fecha_nac` datetime DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_doctor`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (6,'parra ','entre rios','veterinaria','1990-01-31 20:00:00','anahi jacki'),(9,'Arrova Limachi','Calle Venezuela','Tomografa','1997-06-05 20:00:00','Celeste'),(3,'mayta mamani','la portada','cardiologia','1991-01-10 20:00:00','gonzalo'),(4,'mayta mamani','la portada','dermatologo','2004-09-20 20:00:00','grover'),(12,'Callizaya','Obrajes','Cirugia General','1976-08-24 20:00:00','Alesandro'),(8,'kantuta','pruebita','enfermera','2019-09-08 20:00:00','vanesa'),(10,'quiroz','sopocachi','neumologo','1976-12-18 20:00:00','franz'),(11,'pruebita','miraflores','veterinaria','1990-12-31 20:00:00','pruebita'),(13,'Ramirez','Pampahasi','Neumologia','1964-08-08 20:00:00','Esteban '),(14,'Ramirez','Munaypata','Pediatra','1974-04-08 20:00:00','Freddy'),(15,'Fernandez Quiroga','Chasquipampa','Oftalmologia','1976-03-08 20:00:00','Roxana'),(16,'Cordero','Villa Victoria','Psicologia','1981-04-18 20:00:00','Roel'),(17,'Apaza','3 de Mayo','Gastroenterologia','1980-05-26 20:00:00','Alisson'),(18,'Paz Fernandez','Cementerio','Fisioterapia','1986-04-03 20:00:00','Nathali'),(19,'Limachi','Munaypata','Ginecologia','1980-05-07 20:00:00','Evelin'),(20,'Quiroz Gonzales','','Nerocirugia','1975-08-08 20:00:00','Wara '),(21,'Mayta','Villa Victoria','Endocrinologo','1991-11-17 20:00:00','Juan Pablo'),(22,'Gonzales','Villa Fatima','medicina general','1990-02-01 20:00:00','Gonzalo');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `id_paciente` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_nac` datetime DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (7,'patty','villa victoria','1989-04-01 20:00:00','miriam'),(2,'espinal','villa fatima','1996-09-08 20:00:00','Mariela noemi'),(3,'quispe quispe','pedro miranda','1996-02-01 20:00:00','milenka'),(8,'Tancara','La Portada','1978-10-19 20:00:00','Humberto'),(9,'Figuerro','buenos aires','1985-11-28 20:00:00','Marcos'),(10,'Gutierrez Yupanqui','Entre Rios','1993-05-10 20:00:00','Susan'),(11,'Quispe Mamani','Munaypata','1982-08-22 20:00:00','Silvana '),(12,'Paz Paz','El Tejar','1971-10-11 20:00:00','Alejandro'),(13,'Molina Campos','Miraflores','1990-04-11 20:00:00','Alejandra'),(14,'Acho Lugarani','Alto Mariscal Santa Cruz','1990-11-09 20:00:00','Noemi'),(15,'Martinez','Ballivian','1992-12-09 20:00:00','Ximena Soledad'),(16,'Ugarte','El Tejar','1995-03-11 20:00:00','Fabiola'),(17,'Mamani Condori','Tacagua','1993-12-11 20:00:00','Eliana Belen'),(18,'Arrova Limachi','Alto La Portada','1975-07-05 20:00:00','Fernando'),(19,'Uscamayta Wanders','Chamoco Chico','1990-12-11 20:00:00','Cecilia '),(20,'Gonzales','Sopocachi','1992-11-02 20:00:00','Estefany');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-16 23:15:37
