-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Current Database: `demo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `demo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `demo`;

--
-- Table structure for table `accesorios`
--

DROP TABLE IF EXISTS `accesorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accesorios` (
  `id_accesorios` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  PRIMARY KEY (`id_accesorios`),
  UNIQUE KEY `id_accesorios_UNIQUE` (`id_accesorios`),
  KEY `fk_componentes_accesoriso` (`id_componente`),
  KEY `fk_accesorios_patrimonial` (`id_accesorios`),
  CONSTRAINT `fk_accesorios_patrimonial` FOREIGN KEY (`id_accesorios`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_componentes_accesoriso` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesorios`
--

LOCK TABLES `accesorios` WRITE;
/*!40000 ALTER TABLE `accesorios` DISABLE KEYS */;
INSERT INTO `accesorios` VALUES ('1231','123456789014'),('8556','123556789012'),('1234','243455'),('7654','333456789012'),('1213','6453');
/*!40000 ALTER TABLE `accesorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id_area` int(11) NOT NULL AUTO_INCREMENT,
  `id_departamento` int(11) NOT NULL,
  `nombre` varchar(25) CHARACTER SET latin1 NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `descripcion` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_departamento` (`id_departamento`),
  CONSTRAINT `fk_departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,1,'SDA_SECRETARIA',1,''),(2,2,'SOP_SECRETARIA',1,''),(4,4,'INF_UCI',1,''),(5,5,'DIR_ASLEGAL',1,''),(6,29,'GCA_JEFATURA',0,''),(7,29,'GCA_SECRETARIA',1,''),(8,8,'DOC_AUDITORIA',1,''),(9,8,'DOC_SECRETARIA',1,''),(10,8,'DOC_CAPACITACION',1,''),(11,9,'ECO_CTRLPREVIO',1,''),(12,9,'ECO_TESORERIA',1,''),(13,9,'ECO_COMPAG',1,''),(14,9,'ECO_TRAMITE',1,''),(15,9,'ECO_INTCONT',1,''),(16,9,'ECO_JEFATURA',1,''),(17,9,'ECO_CTACTE',1,''),(18,9,'ECO_CAJERO',1,''),(19,10,'EME_JEFATURA',1,''),(20,10,'EME_SECRETARIA',1,''),(21,11,'EPI_JEFATURA',1,''),(22,12,'EST_ADMISION',1,''),(23,12,'EST_INFORMATICA',1,''),(24,12,'EST_PDATOS',1,''),(25,12,'EST_HISCLINICA',1,''),(26,12,'EST_JEFATURA',1,''),(27,13,'FAR_JEFATURA',1,''),(28,13,'FAR_SECRETARIA',1,''),(29,13,'FAR_ALMACEN',1,''),(30,13,'FAR_COMITEFARMA',1,''),(31,13,'FAR_DISPCE',1,''),(32,13,'FAR_PROCSIS',1,''),(33,14,'ITR_SECRETARIA',1,''),(34,15,'LAB_BANCOSANGR',1,''),(35,15,'LAB_ADMISION',1,''),(36,15,'LAB_INMUNOLOGIA',1,''),(37,16,'LOG-INFORMAC',1,''),(38,16,'LOG_ADQUISIC',1,''),(39,16,'LOG_ALMACEN',1,''),(40,16,'LOG_INFORMAC',1,''),(41,16,'LOG_CTRPAT',1,''),(42,17,'MAN_JEFATURA',1,''),(43,18,'GOB_SIPGINECO',1,''),(44,19,'MED_ICTUS',1,''),(45,19,'MED_ENCEFALOGRAFIA',1,''),(46,19,'MED_JEFATURA',1,''),(47,19,'MED_NEUMOLOGIA',1,''),(48,19,'MED_PCT',1,''),(49,19,'MED_ENDOSCOPIA',1,''),(50,20,'PED_PERINATAL',1,''),(51,21,'OCI_SECRETARIA',1,''),(52,21,'OCI_JEFATURA',1,''),(53,22,'PAT_SECRETARIA',1,''),(54,22,'PAT_RESULTADOS',1,''),(55,23,'PER_CTRLTIEMPOS',1,''),(56,23,'PER_INCENTIVOS',1,''),(57,23,'PER_PLHCAS',1,''),(58,23,'PER_JEFATURA',1,''),(59,23,'PER_ADMINISTRAC',1,''),(60,23,'PER_TECNICA',1,'');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Jefe Area',1,''),(2,'Secretario(a)',1,''),(3,'Obrero',1,'');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente`
--

DROP TABLE IF EXISTS `componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente` (
  `id_componente` varchar(20) NOT NULL,
  `id_modelo` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `garantia` decimal(4,2) NOT NULL,
  `caracteristica` varchar(50) NOT NULL,
  PRIMARY KEY (`id_componente`),
  UNIQUE KEY `id_componente_UNIQUE` (`id_componente`),
  KEY `fk_modelo_componente` (`id_modelo`),
  CONSTRAINT `fk_modelo_componente` FOREIGN KEY (`id_modelo`) REFERENCES `modelo` (`id_modelo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente`
--

LOCK TABLES `componente` WRITE;
/*!40000 ALTER TABLE `componente` DISABLE KEYS */;
INSERT INTO `componente` VALUES ('121232',13,1,0.50,'12'),('1212412',13,1,1.00,'12'),('121312',15,2,0.25,'1212*1231'),('123412',4,2,3.00,'423'),('123456788812',9,2,3.00,'7'),('123456789010',8,3,2.00,'32'),('123456789011',3,2,2.00,'4'),('123456789012',8,3,2.00,'44'),('123456789013',15,1,3.00,'14'),('123456789014',11,2,2.00,'rojo'),('123456789015',13,4,3.00,'4'),('123456789016',8,3,2.00,'1'),('123456789017',8,2,3.00,'4'),('123456789018',12,1,2.00,'verde'),('123456789019',4,3,2.00,'34'),('123456789055',14,4,2.00,'5'),('123556789012',12,2,1.00,'5'),('12434',15,1,2.00,'132'),('1324121',8,2,0.25,'4'),('23',8,2,0.50,'42'),('243455',11,3,2.00,'rojo'),('333456789012',11,2,3.00,'rojo'),('343',8,1,0.25,'234'),('343224',12,1,2.00,'rojo'),('432',4,4,2.00,'452'),('455667',4,4,2.00,'1000x100'),('56543',13,1,1.00,'323'),('589654',4,2,1.00,'78*9875'),('6453',12,2,2.00,'rojo'),('7544',8,1,2.00,'200'),('8653',8,2,3.00,'45'),('87855',4,1,2.00,'6445*987');
/*!40000 ALTER TABLE `componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computador`
--

DROP TABLE IF EXISTS `computador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computador` (
  `id_computador` varchar(20) NOT NULL,
  `id_cpu` varchar(20) NOT NULL,
  `id_monitor` varchar(20) NOT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_computador`),
  KEY `fk_cpu_computador` (`id_cpu`),
  KEY `fk_cpu_monitor` (`id_monitor`),
  KEY `fk_cpu_empleado` (`id_empleado`),
  KEY `fk_patrimonial` (`id_computador`),
  CONSTRAINT `fk_cpu_computador` FOREIGN KEY (`id_cpu`) REFERENCES `cpu` (`id_cpu`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpu_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cpu_monitor` FOREIGN KEY (`id_monitor`) REFERENCES `monitor` (`id_monitor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computador`
--

LOCK TABLES `computador` WRITE;
/*!40000 ALTER TABLE `computador` DISABLE KEYS */;
INSERT INTO `computador` VALUES ('compu1','435','12344',1,0),('compu2','532323','456112',18,0);
/*!40000 ALTER TABLE `computador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computador_accesorios`
--

DROP TABLE IF EXISTS `computador_accesorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computador_accesorios` (
  `id_computador_accesorios` int(11) NOT NULL AUTO_INCREMENT,
  `id_computador` varchar(20) NOT NULL,
  `id_accesorios` varchar(20) NOT NULL,
  PRIMARY KEY (`id_computador_accesorios`),
  KEY `fk_computador_accesorios` (`id_computador`),
  KEY `fk_accesorios_accesorios` (`id_accesorios`),
  CONSTRAINT `fk_accesorios_accesorios` FOREIGN KEY (`id_accesorios`) REFERENCES `accesorios` (`id_accesorios`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_computador_accesorios` FOREIGN KEY (`id_computador`) REFERENCES `computador` (`id_computador`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computador_accesorios`
--

LOCK TABLES `computador_accesorios` WRITE;
/*!40000 ALTER TABLE `computador_accesorios` DISABLE KEYS */;
INSERT INTO `computador_accesorios` VALUES (42,'compu1','1231'),(43,'compu1','1213'),(44,'compu2','7654'),(45,'compu2','8556');
/*!40000 ALTER TABLE `computador_accesorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpu`
--

DROP TABLE IF EXISTS `cpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cpu` (
  `id_cpu` varchar(20) NOT NULL,
  `id_software` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_cpu`),
  UNIQUE KEY `id_cpu_UNIQUE` (`id_cpu`),
  KEY `fk_cpu_patrimonial` (`id_cpu`),
  KEY `fk_cpu_software` (`id_software`),
  CONSTRAINT `fk_cpu_patrimonial` FOREIGN KEY (`id_cpu`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpu_software` FOREIGN KEY (`id_software`) REFERENCES `software` (`id_software`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu`
--

LOCK TABLES `cpu` WRITE;
/*!40000 ALTER TABLE `cpu` DISABLE KEYS */;
INSERT INTO `cpu` VALUES ('2323',1,1),('234234',4,1),('435',1,0),('532323',4,0);
/*!40000 ALTER TABLE `cpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpu_componentes`
--

DROP TABLE IF EXISTS `cpu_componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cpu_componentes` (
  `id_cpu_componentes` int(11) NOT NULL AUTO_INCREMENT,
  `id_cpu` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_cpu_componentes`),
  KEY `fk_cpu_componentes` (`id_cpu`),
  KEY `fk_cp_componentes` (`id_componente`),
  CONSTRAINT `fk_cpu_componentes` FOREIGN KEY (`id_cpu`) REFERENCES `cpu` (`id_cpu`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cp_componentes` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu_componentes`
--

LOCK TABLES `cpu_componentes` WRITE;
/*!40000 ALTER TABLE `cpu_componentes` DISABLE KEYS */;
INSERT INTO `cpu_componentes` VALUES (72,'234234','1324121',0),(73,'234234','23',0),(74,'2323','8653',0),(75,'2323','123456789011',0),(77,'435','123456789017',0),(78,'532323','123456788812',0);
/*!40000 ALTER TABLE `cpu_componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `iniciales` varchar(3) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  UNIQUE KEY `iniciales_UNIQUE` (`iniciales`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'ADMINITRACION','SDA',1,''),(2,'CENTRO QUIRURGICO','SOP',1,''),(3,'CIRUGIA','CIR',1,''),(4,'CUIDADOS INTENCIVOS','INF',1,''),(5,'DEFENSORIA DEL USUARIO','DIR',1,''),(8,'DOCENCIA','DOC',1,''),(9,'ECONOMIA','ECO',1,''),(10,'EMERGENCIA','EME',1,''),(11,'EPIDEMIOLOGIA','EPI',1,''),(12,'ESTADISTICA','EST',1,''),(13,'FARMACIA','FAR',1,''),(14,'IMAGEN Y TERAPIA RADIANTE','ITR',1,''),(15,'LABORATORIO','LAB',1,''),(16,'LOGISTICA','LOG',1,''),(17,'MANTENIMIENTO','MAN',1,''),(18,'MATERNIDAD','GOB',1,''),(19,'MEDICINA','MED',1,''),(20,'NEONATOLOGIA','PED',1,''),(21,'OCI','OCI',1,''),(22,'PATOLOGIA','PAT',1,''),(23,'PERSONAL','PER',1,''),(24,'PLANEAMIENTO','PLA',1,''),(25,'SEGUROS','SEG',1,''),(26,'SERVICIO SOCIAL','SSO',1,''),(27,'SUB DIRECCION','SUD',1,''),(28,'UCI NEONATO','NEO',1,''),(29,'DIRECCION EJECUTIVA','GCA',1,NULL);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_orden`
--

DROP TABLE IF EXISTS `detalle_orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_orden` (
  `id_orden_compra` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  PRIMARY KEY (`id_componente`),
  KEY `fk_orden_detalle` (`id_orden_compra`),
  KEY `fk_componente_detalle` (`id_componente`),
  CONSTRAINT `fk_componente_detalle` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_orden_detalle` FOREIGN KEY (`id_orden_compra`) REFERENCES `orden_compra` (`id_orden_compra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_orden`
--

LOCK TABLES `detalle_orden` WRITE;
/*!40000 ALTER TABLE `detalle_orden` DISABLE KEYS */;
INSERT INTO `detalle_orden` VALUES ('123412','123456789016'),('123412','123456789019'),('124312','123412'),('124312','432'),('23','123456789011'),('323','123456789012'),('324423','123456789010'),('34','123456789017'),('3434535','121232'),('345','123456788812'),('345','123456789015'),('345','123456789055'),('345','123556789012'),('345','333456789012'),('4547645','455667'),('5324','123456789013'),('5432','121312'),('5432','12434'),('6433434','1324121'),('6433434','8653'),('645645','1212412'),('645645','56543'),('65433','243455'),('65433','343224'),('65433','6453'),('733434','23'),('7454323','343'),('7845','589654'),('7845','87855'),('785334','7544'),('8657656','123456789014'),('8657656','123456789018');
/*!40000 ALTER TABLE `detalle_orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_cargo` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `apellidos` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nombres` varchar(50) CHARACTER SET latin1 NOT NULL,
  `usuario` varchar(20) CHARACTER SET latin1 NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_cargo` (`id_cargo`),
  KEY `fk_area` (`id_area`),
  CONSTRAINT `fk_area_ampleado` FOREIGN KEY (`id_area`) REFERENCES `area` (`id_area`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cargo_empleado` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,2,1,'Haro Araujo','Eder Martin','ederm',1,1),(17,1,1,'Gamboa','Babsy','bajogale',1,1),(18,3,2,'Juan','SAnches','juancho',1,1),(19,3,2,'Raymond','Bazan','raymen',1,0),(20,3,2,'Gutierres','Mauro','mauri',1,0);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_software`
--

DROP TABLE IF EXISTS `empleado_software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado_software` (
  `id_empleado_software` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_software` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado_software`),
  KEY `fk_empleado_software` (`id_empleado`),
  KEY `fk_software_software` (`id_software`),
  KEY `fk_empleado_sp` (`id_empleado`),
  KEY `fk_software_sp` (`id_software`),
  CONSTRAINT `fk_empleado_sp` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_software_sp` FOREIGN KEY (`id_software`) REFERENCES `software` (`id_software`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_software`
--

LOCK TABLES `empleado_software` WRITE;
/*!40000 ALTER TABLE `empleado_software` DISABLE KEYS */;
INSERT INTO `empleado_software` VALUES (80,1,6),(81,1,5),(82,17,6),(83,1,6),(84,1,5),(85,18,6),(86,18,6),(87,1,6),(88,1,5),(89,18,6),(90,1,6),(91,1,5),(92,19,6),(93,19,5),(94,19,6),(95,19,5),(96,20,6),(97,20,5);
/*!40000 ALTER TABLE `empleado_software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `id_equipo` varchar(20) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_equipo`),
  KEY `fk_equipo_patrimonial` (`id_equipo`),
  KEY `fk_equipo_componente` (`id_componente`),
  KEY `fk_equipo_empleado` (`id_empleado`),
  CONSTRAINT `fk_equipo_componente` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo_patrimonial` FOREIGN KEY (`id_equipo`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_componente`
--

DROP TABLE IF EXISTS `historial_componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_componente` (
  `id_historial_componente` int(11) NOT NULL AUTO_INCREMENT,
  `id_componente` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id_historial_componente`),
  KEY `fk_historial_componente` (`id_componente`),
  CONSTRAINT `fk_historial_componente` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_componente`
--

LOCK TABLES `historial_componente` WRITE;
/*!40000 ALTER TABLE `historial_componente` DISABLE KEYS */;
INSERT INTO `historial_componente` VALUES (1,'123456789015','2011-11-13','Se Habilito'),(2,'1324121','2011-11-13','Se Habilito'),(3,'333456789012','2011-11-13','Se Inserto en el computador compu3'),(4,'6453','2011-11-13','Se retiro en el computador compu3'),(5,'123456789012','2011-11-13','Se retiro en el computador compu2'),(6,'1324121','2011-11-13','Se Inserto en el computador compu2'),(7,'8653','2011-11-13','Se Inserto en el computador compu2'),(8,'121312','2011-11-14','Se Habilito '),(9,'121312','2011-11-14','Se Habilito '),(10,'123456789013','2011-11-14','Se Habilito '),(11,'123456788812','2011-11-14','Se Habilito '),(12,'123456789011','2011-11-14','Se Habilito '),(13,'123456789055','2011-11-14','Se Habilito '),(14,'123456789015','2011-11-14','Se Habilito '),(15,'123456789012','2011-11-14','Se Habilito '),(16,'123456789017','2011-11-14','Se Retiro en el computador compu3'),(17,'23','2011-11-14','Se Inhabilito en el computador compu3'),(18,'455667','2011-11-14','Se Habilito'),(19,'123456789016','2011-11-14','Se Inhabilito en el computador compu1'),(20,'455667','2011-11-14','Se Habilito'),(21,'123412','2011-11-14','Se Habilito'),(22,'123456789016','2011-11-14','Se Habilito'),(23,'455667','2011-11-14','Se Retiro en el computador compu2'),(24,'123412','2011-11-14','Se Inserto en el computador compu2'),(25,'123412','2011-11-14','Se Inhabilito en el computador compu2'),(26,'455667','2011-11-14','Se Inserto en el computador compu2'),(27,'123456789019','2011-11-14','Se Habilito'),(28,'123412','2011-11-14','Se Habilito'),(29,'123456789012','2011-11-14','Se Inhabilito en el computador compu2'),(30,'123456789016','2011-11-14','Se Inserto en el computador compu2'),(31,'243455','2011-11-15','Se Inserto en el computador compu2'),(32,'123456789018','2011-11-15','Se Inserto en el computador compu2'),(33,'6453','2011-11-15','Se Inhabilito en el computador compu2'),(34,'123556789012','2011-11-15','Se Inserto en el computador compu2'),(35,'123456789014','2011-11-15','Se Retiro en el computador compu2'),(36,'123456789018','2011-11-15','Se Retiro en el computador compu2'),(37,'6453','2011-11-15','Se Habilito'),(38,'123412','2011-11-15','Se Retiro en el computador compu3'),(39,'123456789019','2011-11-15','Se Inserto en el computador compu3'),(40,'123456789012','2011-11-15','Se Habilito'),(41,'123456789017','2011-11-15','Se Retiro en el computador compu3'),(42,'123456789018','2011-11-15','Se Retiro en el computador compu3'),(43,'123456789016','2011-11-15','Se Retiro en el computador compu2'),(44,'123556789012','2011-11-15','Se Retiro en el computador compu2'),(45,'123456789010','2011-11-15','Se Inhabilito en el computador compu1'),(46,'123456789012','2011-11-15','Se Inhabilito en el computador compu1'),(47,'1324121','2011-11-15','Se Inserto en el computador compu1'),(48,'23','2011-11-15','Se Inserto en el computador compu1'),(49,'123412','2011-11-15','Se Retiro en el computador compu1'),(50,'123456789019','2011-11-15','Se Inserto en el computador compu1'),(51,'123456789019','2011-11-15','Se Inhabilito en el computador compu1'),(52,'123412','2011-11-15','Se Inserto en el computador compu1'),(53,'123456789014','2011-11-15','Se Inserto en el computador compu1'),(54,'6453','2011-11-15','Se Inserto en el computador compu1'),(55,'243455','2011-11-15','Se Inhabilito en el computador compu1'),(56,'123456789016','2011-11-15','Se Retiro en el CPU 435'),(57,'123456789016','2011-11-15','Se Retiro en el CPU 435'),(58,'123456789016','2011-11-15','Se Inserto en el CPU 435'),(59,'123456789017','2011-11-16','Se Retiro en el CPU 435'),(60,'123456789017','2011-11-16','Se Retiro en el CPU 435'),(61,'123456789017','2011-11-16','Se Inserto en el CPU 435'),(62,'123456789016','2011-11-29','Se Inhabilito en el computador compu1'),(63,'123456789015','2011-11-30','Se Retiro del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Gamboa Babsy'),(64,'121232','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Gamboa Babsy'),(65,'121232','2011-11-30','Se Habilito'),(66,'56543','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Haro Araujo Eder Martin'),(67,'56543','2011-11-30','Se Habilito'),(68,'1212412','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Gamboa Babsy'),(69,'121232','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Haro Araujo Eder Martin'),(70,'1212412','2011-11-30','Se Retiro del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Gamboa Babsy'),(71,'121232','2011-11-30','Se Habilito'),(72,'1212412','2011-11-30','Se Retiro del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Gamboa Babsy'),(73,'121232','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Haro Araujo Eder Martin'),(74,'121232','2011-11-30','Se Habilito'),(75,'123456789055','2011-11-30','Se Inhabilito del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(76,'123456789055','2011-11-30','Se Inhabilito del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(77,'123456789055','2011-11-30','Se Retiro del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(78,'123456789055','2011-11-30','Se Retiro del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(79,'123456789055','2011-11-30','Se Retiro del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(80,'123456789055','2011-11-30','Se Inhabilito del area SOP_SECRETARIA del Departamento deCENTRO QUIRURGICO al usuario Gutierres Mauro'),(81,'123456789055','2011-11-30','Se Habilito'),(82,'123456789055','2011-11-30','Se Inhabilito del area SDA_SECRETARIA del Departamento deADMINITRACION al usuario Haro Araujo Eder Martin'),(83,'123456789055','2011-11-30','Se Habilito');
/*!40000 ALTER TABLE `historial_componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impresora`
--

DROP TABLE IF EXISTS `impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impresora` (
  `id_impresora` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_impresora`),
  UNIQUE KEY `id_impresora_UNIQUE` (`id_impresora`),
  KEY `fk_impresora_componentes` (`id_componente`),
  KEY `fk_impresora_empleado` (`id_empleado`),
  KEY `fk_impresora_patrimonial` (`id_impresora`),
  CONSTRAINT `fk_impresora_componentes` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_impresora_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_impresora_patrimonial` FOREIGN KEY (`id_impresora`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impresora`
--

LOCK TABLES `impresora` WRITE;
/*!40000 ALTER TABLE `impresora` DISABLE KEYS */;
/*!40000 ALTER TABLE `impresora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `Descripcion` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id_marca`),
  UNIQUE KEY `nombre_marca_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'HP',1,''),(2,'Epson',1,''),(3,'Intel',1,''),(4,'ASUS',1,''),(5,'GIGABYTE',1,''),(6,'LG',1,'');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `id_modelo` int(11) NOT NULL AUTO_INCREMENT,
  `id_marca` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `caracteristica` varchar(20) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_modelo`),
  UNIQUE KEY `nombre_modelo_UNIQUE` (`nombre`),
  KEY `fk_marca_modelo` (`id_marca`),
  KEY `fk_tipo_modelo` (`id_tipo`),
  CONSTRAINT `fk_marca_modelo` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tipo_modelo` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (2,5,11,'Core','sad asd a',1),(3,4,7,'MPGT','sad asas as ',1),(4,1,8,'pkdfdf','as',1),(5,4,7,'MAxell','as',1),(6,1,7,'xfoma','sdf',1),(7,3,5,'MANso','as a ',1),(8,1,2,'Seagate','bueno',1),(9,1,6,'pkmtl','123/120/',1),(10,3,4,'adasd asd','sadasd',1),(11,1,9,'XSCroll','optico',1),(12,1,10,'Trclon','bacan',1),(13,2,13,'xpae','Nro Toner',1),(14,2,15,'elg xra','Velocidad',1),(15,1,16,'Pavillon 2140dv','Pulgadas',1),(16,1,2,'xp turbo disc','Capacidad',1);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitor` (
  `id_monitor` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  PRIMARY KEY (`id_monitor`),
  KEY `fk_componente_monitor` (`id_componente`),
  KEY `fk_monitor_patrimonial` (`id_monitor`),
  CONSTRAINT `fk_componente_monitor` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_monitor_patrimonial` FOREIGN KEY (`id_monitor`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` VALUES ('12344','123412'),('1241','123456789019'),('43','432'),('23','455667'),('456112','589654');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_compra`
--

DROP TABLE IF EXISTS `orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_compra` (
  `id_orden_compra` varchar(20) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_orden_compra`),
  KEY `fk_proveedor_orden` (`id_proveedor`),
  CONSTRAINT `fk_proveedor_orden` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra`
--

LOCK TABLES `orden_compra` WRITE;
/*!40000 ALTER TABLE `orden_compra` DISABLE KEYS */;
INSERT INTO `orden_compra` VALUES ('123412',41,'2011-10-01'),('124312',26,'2011-10-11'),('23',27,'2007-09-30'),('323',28,'2011-09-30'),('324423',27,'2011-10-01'),('34',26,'2011-09-30'),('3434535',27,'2011-11-23'),('345',28,'2009-11-12'),('4547645',27,'2011-10-13'),('5324',27,'2011-09-16'),('5432',41,'2011-10-25'),('6433434',42,'2011-11-13'),('645645',41,'2011-11-30'),('65433',41,'2011-10-13'),('733434',41,'2011-11-12'),('7454323',42,'2011-11-29'),('7845',27,'2011-11-15'),('785334',42,'2011-11-16'),('8657656',42,'2011-10-01');
/*!40000 ALTER TABLE `orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonial`
--

DROP TABLE IF EXISTS `patrimonial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patrimonial` (
  `id_patrimonial` varchar(20) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_patrimonial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonial`
--

LOCK TABLES `patrimonial` WRITE;
/*!40000 ALTER TABLE `patrimonial` DISABLE KEYS */;
INSERT INTO `patrimonial` VALUES ('',0),('1213',0),('1231',0),('1231212',0),('1234',0),('12344',0),('1241',0),('21121212',0),('213123123',0),('23',0),('2323',0),('232323',0),('2323242342',0),('23233',0),('23234',0),('232342342',0),('234234',0),('3242323',0),('345435',0),('43',0),('435',0),('456112',0),('532323',0),('65',0),('7654',0),('8556',0);
/*!40000 ALTER TABLE `patrimonial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portatil`
--

DROP TABLE IF EXISTS `portatil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portatil` (
  `id_portatil` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `id_componente` varchar(20) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_software` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_portatil`),
  KEY `fk_portatil_componente` (`id_componente`),
  KEY `fk_portatil_empleado` (`id_empleado`),
  KEY `fk_portatil_patrimonial` (`id_portatil`),
  KEY `fk_portatil_software` (`id_software`),
  CONSTRAINT `fk_portatil_componente` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_portatil_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_portatil_patrimonial` FOREIGN KEY (`id_portatil`) REFERENCES `patrimonial` (`id_patrimonial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_portatil_software` FOREIGN KEY (`id_software`) REFERENCES `software` (`id_software`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portatil`
--

LOCK TABLES `portatil` WRITE;
/*!40000 ALTER TABLE `portatil` DISABLE KEYS */;
INSERT INTO `portatil` VALUES ('23233','lapa1','121312',17,4,0);
/*!40000 ALTER TABLE `portatil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direcion` varchar(500) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `activa` tinyint(4) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (26,'34','34','34','34',1,''),(27,'eder','23','53','23',1,''),(28,'JUan Ramires','asd','as','asd',1,''),(41,'eder araho hato','wq','as','wq',1,''),(42,'eas mama','123','23','123',1,''),(43,'ewe','wew','wew','we',1,'');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_compu`
--

DROP TABLE IF EXISTS `registro_compu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_compu` (
  `id_registro_compu` int(11) NOT NULL,
  `id_computador` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id_registro_compu`),
  KEY `fk_registro_computador` (`id_computador`),
  CONSTRAINT `fk_registro_computador` FOREIGN KEY (`id_computador`) REFERENCES `computador` (`id_computador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_compu`
--

LOCK TABLES `registro_compu` WRITE;
/*!40000 ALTER TABLE `registro_compu` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_compu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resgitro_componentes`
--

DROP TABLE IF EXISTS `resgitro_componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resgitro_componentes` (
  `id_resgitro_componentes` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_resgitro_componentes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resgitro_componentes`
--

LOCK TABLES `resgitro_componentes` WRITE;
/*!40000 ALTER TABLE `resgitro_componentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `resgitro_componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `id_software` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_software`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software`
--

LOCK TABLES `software` WRITE;
/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` VALUES (1,'XP',1,1),(2,'Winrar',2,1),(3,'Office 2007',2,1),(4,'Ubuntu',1,1),(5,'SisFarma',3,1),(6,'SAT',3,1);
/*!40000 ALTER TABLE `software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `ubicacion` tinyint(4) NOT NULL,
  `caracteristica` varchar(20) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tipo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (2,'Disco Duro',2,'Capacidad',1),(3,'Memoria Ran',2,'Capacidad',1),(4,'Tarjeta Video',2,'Memoria',1),(5,'Placa Madre',2,'Cache',1),(6,'Tarjeta Red',2,'Velocidad',1),(7,'Tarjeta Sonido',2,'Canales',1),(8,'Monitor',1,'Resolucion',1),(9,'Mause',3,'Color',1),(10,'Teclado',3,'Color',1),(11,'Fuente',2,'Voltaje',1),(12,'Case',2,'Color',1),(13,'Impresora',5,'Nr. Toner',1),(14,'Lectora Interna',2,'Velocidad',1),(15,'Lectora Externa',4,'Velocidad',1),(16,'Laptop',6,'Pulgadas',1),(17,'Notebook',6,'Pulgadas',1);
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `nivel` tinyint(4) NOT NULL,
  `activa` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (8,'Eder Martin','Haro Araujo','edham','123456',2,1),(9,'Eder Martin','Haro Araujo','ederm','123456',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-11-30 12:12:25
