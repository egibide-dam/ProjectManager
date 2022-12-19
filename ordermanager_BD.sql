-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionpedidos
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idpedido` int NOT NULL AUTO_INCREMENT,
  `idproveedor` int NOT NULL,
  `idpieza` int NOT NULL,
  `idproyecto` int NOT NULL,
  `cantidad` float NOT NULL,
  `alta` tinyint(1) NOT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `ped_prov_fk_idx` (`idproveedor`),
  KEY `ped_piez_fk_idx` (`idpieza`),
  KEY `ped_proy_fk_idx` (`idproyecto`),
  CONSTRAINT `ped_piez_fk` FOREIGN KEY (`idpieza`) REFERENCES `piezas` (`idpieza`),
  CONSTRAINT `ped_prov_fk` FOREIGN KEY (`idproveedor`) REFERENCES `proveedores` (`idproveedor`),
  CONSTRAINT `ped_proy_fk` FOREIGN KEY (`idproyecto`) REFERENCES `proyectos` (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,1,1,4,0),(2,3,6,1,150,0),(3,4,8,1,10,0),(4,2,4,7,8,1),(5,2,3,7,8,1),(6,3,6,5,2,1),(7,3,5,6,1,1),(8,4,9,1,1,1),(9,2,3,7,8,1),(10,3,5,5,2,1),(11,3,6,5,1,1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piezas`
--

DROP TABLE IF EXISTS `piezas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piezas` (
  `idpieza` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `descripcion` text,
  `idproveedor` int NOT NULL,
  `alta` tinyint(1) NOT NULL,
  PRIMARY KEY (`idpieza`),
  KEY `piez_prov_fk_idx` (`idproveedor`),
  CONSTRAINT `piez_prov_fk` FOREIGN KEY (`idproveedor`) REFERENCES `proveedores` (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piezas`
--

LOCK TABLES `piezas` WRITE;
/*!40000 ALTER TABLE `piezas` DISABLE KEYS */;
INSERT INTO `piezas` VALUES (1,'SPITFIRE FORMULA Ruedas',14.45,'Four Conical Full(White/Blue) 53MM 99A',1,1),(2,'RUEDAS SPITFIRE BIGHEAD',9.99,'Ruedas 54mm. Estampado logo Spitfire Azul',1,0),(3,'RUEDAS ROLLER QUAD OXELO',5.95,'Ruedas Roller Quad Oxelo Adulto Negro 60 mm 82 a',2,1),(4,'RUEDAS PATINES RIO COASTER',3.9,'62 mm x 36 mm - No compatibles con separadores de 8-10mm',2,1),(5,'ROCKRIDER RUEDA DELANTERA V-DRAKE',40.95,'Rueda 27.5\" Pulgadas Delantera V-Brake Doble Pared Bicicleta Montaña Negro',3,1),(6,'RIVERSIDE RUEDA DELANTERA',49.95,'Rueda Bicicleta MTB 29\'\' Delantera Freno Disco Doble Pared Negra',3,1),(7,'OLDSHOOL BOARD SCREAMING HAND',48.45,'Skateboard Santa Cruz Screaming Hand - Iridescent - 7 láminas de arce norteamericano.',4,1),(8,'OLDSCHOOL SKATEBOARD MANDALA HAND',52.99,'Skateboard Santa Cruz Mandala Hand. Skate técnico urbano - 7 láminas de arce norteamericano.',4,1),(9,'SKATEBOARD EVERSLICK (ROSKOPP MISPRINT)',78.95,'Tabla Santa Cruz Skateboards Rob Roskopp Misprint Everslick. Las Everslicks son las tablas slick que se deslizan más rápido y son 5 veces más resistentes que una tabla estándar de 7 capas. ',4,1),(10,'TABLA CRUISER ALIEN WORKSHOP',81.95,'alto rendimiento hecha de una combinación de 7-ply de arce canadiense y de epoxy.',8,1),(11,'EJE VENTURE',19.95,'Eje Skate Venture All Polished Hi 5.6\"',9,0);
/*!40000 ALTER TABLE `piezas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idproveedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `alta` tinyint(1) NOT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Perico','Palotes','Av. Gasteiz 34, Vitoria',1),(2,'Lucas','Pérez Gómez','Calle Falsa 12',1),(3,'Pedro','Onandia','Kalea bat 1',1),(4,'Irene','Brea Elorza','Avenida ciudad 44',1),(5,'Mario','Cortejos','Avenida Lejana 123',0),(6,'Enrique','Vargas Castaño','Calle Txikita 2',1),(7,'Jose Manuel','Viela Duque','Calle San Millán 13',1),(8,'Maite','Orduña Juarez','Avenida de Maria Cristina 8',1),(9,'Josune','Carhartt','General Álava 1',0);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `idproyecto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `ciudad` varchar(40) DEFAULT NULL,
  `alta` tinyint(1) NOT NULL,
  PRIMARY KEY (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'OLDSCHOOL SKATEBOARD','VITORIA',1),(2,'ROLLERBLADE INLINE','BILBAO',1),(3,'CRUISER SKATE BOARD','SANSEBASTIAN',1),(4,'CASCOS BICI','PAMPLONA',0),(5,'MOUNTAIN BIKE H2','VITORIA',1),(6,'CRUISER BIKE KIDS','SANSEBASTIAN',1),(7,'CLASSIC VINTAGE ROLLERSKATES','PAMPLONA',1),(8,'INLINE ROLLING SKATE RACE','BILBAO',1);
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestionpedidos'
--

--
-- Dumping routines for database 'gestionpedidos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-19  2:35:11
