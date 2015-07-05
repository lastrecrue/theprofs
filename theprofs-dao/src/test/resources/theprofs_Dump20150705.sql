CREATE DATABASE  IF NOT EXISTS `theprofs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `theprofs`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: theprofs
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discription` varchar(254) DEFAULT NULL,
  `prof_id` int(11) NOT NULL,
  `type_cours_id` int(11) NOT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cours_personne_idx` (`prof_id`),
  KEY `fk_cours_type_cours1_idx` (`type_cours_id`),
  CONSTRAINT `fk_cours_personne` FOREIGN KEY (`prof_id`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cours_type_cours1` FOREIGN KEY (`type_cours_id`) REFERENCES `cours` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
INSERT INTO `annonce` VALUES (2,'hhhhhh',1,19,'zzzz'),(3,'discription test',1,19,'1'),(4,'discription test',1,2,'1'),(5,'discription test',1,18,'1'),(6,'discription test',1,18,'2'),(7,'discription test',1,19,'ville test'),(8,'discription test',1,2,'ville test'),(9,'discription test',1,2,'ville test'),(10,'discription test',1,2,'ville test'),(11,'discription test',1,2,'ville test'),(12,'discription test',1,2,'ville test'),(13,'discription test',1,2,'ville test');
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
INSERT INTO `cours` VALUES (2,'1','2','ccc'),(18,'1','2','fffff'),(19,'niveau test','type test','libelle test'),(20,'niveau test','type test','libelle test'),(21,'niveau test','type test','libelle test'),(22,'niveau test','type test','libelle test'),(25,'niveau test','type test','libelle test'),(28,'niveau test','type test','libelle test'),(32,'niveau test','type test','libelle test'),(35,'niveau test','type test','libelle test'),(38,'niveau test','type test','libelle test'),(41,'niveau test','type test','libelle test'),(44,'niveau test','type test','libelle test'),(47,'niveau test','type test','libelle test'),(49,'niveau test','type test','libelle test'),(52,'niveau test','type test','libelle test');
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_prof`
--

DROP TABLE IF EXISTS `note_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note_prof` (
  `eleve_id` int(11) NOT NULL,
  `prof_id` int(11) NOT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`eleve_id`,`prof_id`),
  KEY `fk_personne_has_personne_personne2_idx` (`prof_id`),
  KEY `fk_personne_has_personne_personne1_idx` (`eleve_id`),
  CONSTRAINT `fk_personne_has_personne_personne1` FOREIGN KEY (`eleve_id`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_has_personne_personne2` FOREIGN KEY (`prof_id`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_prof`
--

LOCK TABLES `note_prof` WRITE;
/*!40000 ALTER TABLE `note_prof` DISABLE KEYS */;
INSERT INTO `note_prof` VALUES (1,2,3),(2,3,5);
/*!40000 ALTER TABLE `note_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `pwd` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (1,'dddd','qqqq','tttt','eeee'),(2,'sssss','xxxxx','zzzzz','vvvvv'),(3,'nom test','prenom test','pwd test','email test'),(4,'nom test','prenom test','pwd test','email test'),(5,'nom test','prenom test','pwd test','email test'),(6,'nom test','prenom test','pwd test','email test'),(7,'nom test','prenom test','pwd test','email test'),(8,'nom test','prenom test','pwd test','email test'),(9,'nom test','prenom test','pwd test','email test'),(10,'nom test','prenom test','pwd test','email test'),(11,'nom test','prenom test','pwd test','email test'),(12,'nom test','prenom test','pwd test','email test'),(13,'nom test','prenom test','pwd test','email test'),(14,'nom test','prenom test','pwd test','email test');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-05 23:01:22
